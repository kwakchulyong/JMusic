package tester;

class WriteDiscoBeat {

    static final DrumBeat beat = new DiscoBeat();

    public static final void main(final String[] args) {
        beat.saveToFile();
    }
}
