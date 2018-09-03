package formula1Race;

import java.io.InterruptedIOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PitStop {

    Lock lock = new ReentrantLock();


    public boolean tryToLockPitStop(){
        return lock.tryLock();
    }

    public void goIntoPitStop(String racingCarName){
        try{
            System.out.println("Thread goes into pit stop : " + racingCarName);
            Thread.sleep(50);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        finally {
            lock.unlock();
        }

    }



}
