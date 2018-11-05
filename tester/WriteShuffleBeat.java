package tester;

class WriteShuffleBeat {

    static final DrumBeat beat = new ShuffleBeat();

    public static final void main(final String[] args) {
        beat.saveToFile();
    }
}
