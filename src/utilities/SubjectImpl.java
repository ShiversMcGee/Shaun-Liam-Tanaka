package utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author smhowells
 */
public class SubjectImpl implements ISubject{

    private ArrayList<IObserver> observers = null;

    @Override
    public Boolean registerObserver(IObserver o) {
        Boolean blnAdded = false;

        if (o != null) {

            if (this.observers == null) {
                this.observers = new ArrayList<>();
            }
            if (!this.observers.contains(o)) {
                blnAdded = this.observers.add(o);
            }
        }
        return blnAdded;
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        Boolean blnRemoved = false;

        if (o != null) {
            if (this.observers != null && this.observers.size() > 0) {
                blnRemoved = this.observers.remove(o);
            }
        }
        return blnRemoved;
    }

    @Override
    public void notifyObservers() {
        if (this.observers != null & this.observers.size() > 0) {
            for (IObserver currentObserver : this.observers) {
                currentObserver.update();
            }
        }
    }


}
