package edu.nyu.cs9053.homework5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: blangel
 * Date: 2/20/17
 * Time: 4:02 PM
 */
public class Conductor {

    private static final String LARGO_TEMPO = "largo";

    private static final String MODERATO_TEMPO = "moderato";

    private static final String PRESTISSIMO_TEMPO = "prestissimo";

    public static void main(String[] args) {
        if (!isValid(args)) {
            System.out.printf("Invalid arguments%n");
            return;
        }
        Musician musician;
        switch (args[0]) {
            case LARGO_TEMPO:
                musician = MusicianProvider.createLargoMusician();
                break;
            case MODERATO_TEMPO:
                musician = MusicianProvider.createModeratoMusician();
                break;
            case PRESTISSIMO_TEMPO:
                musician = MusicianProvider.createPrestissimoMusician();
                break;
            default:
                throw new AssertionError(String.format("Unknown tempo - %s", args[0]));
        }
        MusicalInstrument instrument = MusicianProvider.randomlyChoose();
        Conductor conductor = new Conductor(musician, instrument);
        Note[][] ditties = getDitties();
        conductor.playDitties(ditties);
    }

    @SuppressWarnings("fallthrough")
    private static boolean isValid(String[] args) {
        if ((args == null) || (args.length != 1)) {
            return false;
        }
        switch (args[0]) {
            case LARGO_TEMPO:
            case MODERATO_TEMPO:
            case PRESTISSIMO_TEMPO:
                return true;
            default:
                return false;
        }
    }

    private static Note[][] getDitties() {
        Note[] chopsticks = new Note[] {
                new Note("F"), new Note("G"), new Note("F"), new Note("G"), new Note("F"), new Note("G"),
                new Note("F"), new Note("G"), new Note("F"), new Note("G"), new Note("F"), new Note("G"),
                new Note("E"), new Note("G"), new Note("E"), new Note("G"), new Note("E"), new Note("G"),
                new Note("E"), new Note("G"), new Note("E"), new Note("G"), new Note("E"), new Note("G"),
                new Note("D"), new Note("B"), new Note("D"), new Note("B"), new Note("D"), new Note("B"),
                new Note("D"), new Note("B"), new Note("D"), new Note("B"), new Note("D"), new Note("B"),
                new Note("C"), new Note("C"), Note.pause(), Note.pause(), new Note("C"), new Note("C"),
                new Note("C"), new Note("C"), new Note("D"), new Note("B"), new Note("E"), new Note("A")
        };
		Note[] Fabletown = new Note[] {
				new Note("E"), new Note("B"), new Note("C"), new Note("B"), new Note("E"), new Note("B"),
				new Note("C"), new Note("B"), new Note("E"), new Note("B"), new Note("C"), new Note("B"),
				new Note("E"), new Note("D"), new Note("C"), new Note("B"), new Note("E"), new Note("B"),
				new Note("C"), new Note("G"), new Note("E"), new Note("D"), new Note("A"), new Note("B"),
				new Note("C"), new Note("G"), new Note("A"), new Note("B"), new Note("C"), new Note("G"),
				new Note("A"), new Note("B"), new Note("E"), new Note("B"), new Note("D"), Note.pause(),
				new Note("E"), new Note("B"), new Note("C"), new Note("B"), new Note("E"), new Note("B"),
				new Note("C"), new Note("B"), Note.pause(), new Note("B"), new Note("C"), new Note("B")
		};
        return new Note[][] {
                chopsticks, Fabletown,
        };
    }

    private final Musician musician;

    private final MusicalInstrument instrument;

    private final ExecutorService performance;

    private final ExecutorService examplePerformance;

    public Conductor(Musician musician, MusicalInstrument instrument) {
        if ((musician == null) || (instrument == null)) {
            throw new IllegalArgumentException("Musician and instrument must not be null");
        }
        this.musician = musician;
        this.instrument = instrument;
        this.performance = Executors.newSingleThreadExecutor();
        this.examplePerformance = Executors.newSingleThreadExecutor();
    }

    public void playDitties(Note[] ... ditties) {
        if (ditties == null) {
            throw new IllegalArgumentException("Ditties must not be null");
        }
        final long thirtySecondsMs = 30_000;
        final double scale = 100d;
        final long tempo = musician.getTempo();
        for (final Note[] ditty : ditties) {
            // each ditty takes 30 seconds at 100 bpm, scale
            long millisecondsPause = thirtySecondsMs / ditty.length;
            double conversion = (scale / (double) tempo);
            final long expectedMs = (long) (millisecondsPause * conversion);
            performance.submit(new Runnable() {
                @Override public void run() {
                    CountDownLatch latch = new CountDownLatch(ditty.length);
                    musician.playDitty(new DittyCallback() {
                        @Override public void notePlayed(Note note) {
                            System.out.printf("%s%n", note.getNoteValue());
                            latch.countDown();
                        }
                    }, instrument, ditty);
                    try {
                        latch.await();
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(ie);
                    }

                }
            });
            examplePerformance.submit(new Runnable() {
                @Override public void run() {
                    Rhythm rhythm = new Rhythm() {
                        @Override public long getDuration() {
                            return (expectedMs - 5L); // to put first, slightly increase tempo
                        }
                    };
                    for (Note note : ditty) {
                        rhythm.perform();
                        System.out.printf("[expected] %s - [actual] ", note.getNoteValue());
                    }
                }
            });
        }
        performance.shutdown();
        examplePerformance.shutdown();
    }

}
