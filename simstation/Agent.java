package simstation;

import mvc.Utilities;

import java.awt.*;
import java.io.Serializable;



public abstract class Agent implements Runnable, Serializable {

    // the size of the simulation - can be edited here
    public static final int MAX_XC = 500;
    public static final int MAX_YC = 300;

    protected Simulation world;
    protected String name;
    public int xc = Utilities.rng.nextInt(MAX_XC);
    public int yc = Utilities.rng.nextInt(MAX_YC);
    protected Heading heading = Heading.random();
    private boolean suspended = false;
    private boolean stopped = false;
    transient protected Thread myThread;
    protected Color color = Color.WHITE;


    @Override
    public void run() {
        // calls update, falls asleep - when stopped is true, exit while loop
        myThread = Thread.currentThread();
        while (!isStopped()) {
            try {
                update();
                Thread.sleep(20);
                checkSuspended();
            } catch (InterruptedException e) {
                Utilities.error(e.getMessage());
            }
        }
        world.changed();
    }

    public synchronized boolean isStopped() {
        return stopped;
    }

    public synchronized void checkSuspended() {
        try {
            while (!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            Utilities.error(e.getMessage());
        }
    }

    public void start() {
        myThread = new Thread(this);
        myThread.start();
    }

    public synchronized void suspend() {
        suspended = true;
    }

    public synchronized void resume() {
        suspended = false;
        notify();
    }

    public synchronized void stop() {
        stopped = true;
    }

    private void moveNorth() { //higher y is going down. the lower y the higher it is on the screen
        yc = (yc + 1) % MAX_YC;
    }

    private void moveSouth() {
        yc = (yc - 1 + MAX_YC) % MAX_YC;
    }

    private void moveEast() {
        xc = (xc + 1) % MAX_XC;
    }

    private void moveWest() {
        xc = (xc - 1 + MAX_XC) % MAX_XC;
    }

    public void move(int steps) {
        for (int i = 0; i < steps; i++) {
            switch (heading) {
                case NORTH:
                    moveNorth();
                    break;
                case SOUTH:
                    moveSouth();
                    break;
                case WEST:
                    moveWest();
                    break;
                case EAST:
                    moveEast();
                    break;
            }
            world.changed();
        }
    }

    // TODO - override in customization
    public abstract void update();

}
