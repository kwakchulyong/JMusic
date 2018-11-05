package tester;

class WriteClapBeat {

    static final DrumBeat beat = new ClapBeat();

    public static final void main(final String[] args) {
        beat.saveToFile();
    }
}
