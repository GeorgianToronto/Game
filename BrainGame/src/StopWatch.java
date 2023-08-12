import java.awt.Toolkit;

public class StopWatch {
    private long startTime;
    private long stopTime;
    private boolean running;
    private long duration;

    public StopWatch() {
        this.duration = 0; // Default duration of 0 seconds
    }

    public StopWatch(long durationInSeconds) {
        this.duration = durationInSeconds * 1000; // Convert to milliseconds
    }

    public void start() {
        if (!running) {
            startTime = System.currentTimeMillis();
            running = true;
        }
    }

    public void stop() {
        if (running) {
            stopTime = System.currentTimeMillis();
            running = false;
        }
    }
    
    public boolean isRunning(){
        return running;
    }

    public void reset() {
        startTime = 0;
        stopTime = 0;
        running = false;
    }

    public long getElapsedTime() {
        if (running) {
            return System.currentTimeMillis() - startTime;
        } else {
            return stopTime - startTime;
        }
    }

    public void playBeep() {
        Toolkit.getDefaultToolkit().beep();
    }

    public void playLongBeep() {
        // Simulate a long beep (e.g., repeating the beep sound a few times)
        for (int i = 0; i < 3; i++) {
            playBeep();
            try {
                Thread.sleep(500); // Half a second pause between beeps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void runWithBeeps() {
        start();

        while (running) {
            long elapsedTime = getElapsedTime();

            if (duration > 0 && elapsedTime >= duration) {
                stop();
                playLongBeep();
            } else if (elapsedTime >= 1000) {
                playBeep();
                startTime += 1000; // Update start time for the next second
            }

            try {
                Thread.sleep(100); // Check time every 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
