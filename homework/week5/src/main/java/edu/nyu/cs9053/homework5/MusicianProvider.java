package edu.nyu.cs9053.homework5;

import java.util.Random;
/**
 * User: blangel
 * Date: 2/20/17
 * Time: 4:05 PM
 */

public class MusicianProvider {
	
	public class LargoMusician implements Musician{
		private static final long TEMPO_LARGO = 50L;
		private final long thirtySecondsMs = 30_000;
		private final double scale = 100d;
		
		@Override public void playDitty(DittyCallback dittyCallback, MusicalInstrument instrument, Note ... notes){
			long millisecondsPause = thirtySecondsMs / notes.length;
            double conversion = (scale / (double) this.TEMPO_LARGO);
            final long expectedMs = (long) (millisecondsPause * conversion);
			Rhythm rhythm = new Rhythm(){
				@Override public long getDuration(){
                return (expectedMs); 
				}
			};
			for(Note note : notes){
				instrument.play(rhythm,note,new NoteCallback(){
					@Override public void notePlayed(Note note){
						//System.out.printf(note.getNoteValue());
					}
				});
				dittyCallback.notePlayed(note);
			}	
		}
		
		@Override public long getTempo(){
			return this.TEMPO_LARGO;
		}
		
	}
	
	public class ModeratoMusician implements Musician{
		private static final long TEMPO_MODERATO = 100L;
		private final long thirtySecondsMs = 30_000;
		private final double scale = 100d;
		
		@Override public void playDitty(DittyCallback dittyCallback, MusicalInstrument instrument, Note ... notes){
			long millisecondsPause = thirtySecondsMs / notes.length;
            double conversion = (scale / (double) this.TEMPO_MODERATO);
            final long expectedMs = (long) (millisecondsPause * conversion);
			Rhythm rhythm = new Rhythm(){
				@Override public long getDuration(){
                return (expectedMs); 
				}
			};
			for(Note note : notes){
				instrument.play(rhythm,note,new NoteCallback(){
					@Override public void notePlayed(Note note){
						//System.out.printf(note.getNoteValue());
					}
				});
				dittyCallback.notePlayed(note);
			}	
		}
		
		@Override public long getTempo(){
			return this.TEMPO_MODERATO;
		}
		
	}
	
	public class PrestissimoMusician implements Musician{
		private static final long TEMPO_PRESTISSIMO = 200L;
		private final long thirtySecondsMs = 30_000;
		private final double scale = 100d;
		
		@Override public void playDitty(DittyCallback dittyCallback, MusicalInstrument instrument, Note ... notes){
			long millisecondsPause = thirtySecondsMs / notes.length;
            double conversion = (scale / (double) this.TEMPO_PRESTISSIMO);
            final long expectedMs = (long) (millisecondsPause * conversion);
			Rhythm rhythm = new Rhythm(){
				@Override public long getDuration(){
                return (expectedMs); 
				}
			};
			for(Note note : notes){
				
				instrument.play(rhythm,note,new NoteCallback(){
					@Override public void notePlayed(Note note){
						//System.out.printf(note.getNoteValue());
					}
				});
				dittyCallback.notePlayed(note);
			}	
		}
		
		@Override public long getTempo(){
			return this.TEMPO_PRESTISSIMO;
		}
		
	}
	
    public static Musician createLargoMusician() { 
		return new MusicianProvider().new LargoMusician();
    }

    public static Musician createModeratoMusician() {
		return new MusicianProvider().new ModeratoMusician();
    }

    public static Musician createPrestissimoMusician() {
        return new MusicianProvider().new PrestissimoMusician();
    }

    public static MusicalInstrument randomlyChoose() {
		Random r = new Random();
		switch(r.nextInt(15)){
			case 0: return new BassGuitar("","","","",0);
			case 1: return new Bassoon("",0);
			case 2: return new Cello("","","","",0);
			case 3: return new Chenda("","","","",0);
			case 4: return new Clarinet("",0);
			case 5: return new DrumMachine("","","","",0);
			case 6: return new ElectricGuitar("","","","",0);
			case 7: return new Keyboard("","","","",0);
			case 8: return new Piccolo("","","","",0);
			case 9: return new Sanxian("","","","",0);
			case 10: return new Sitar("","","","",0);
			case 11: return new Tenoroon("","","","",0);
			case 12: return new Triangle("","","","",0);
			case 13: return new Tsuzumi("","","","",0);
			case 14: return new Xylophone("",0);
			default: return null;
		}
    }

}
