package com.klaus.observer;

public class ObserverA implements Observer {
    private int myState; // myState 需要跟目标对象的state值保持一致


    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }

    @Override
    public void update(Subject subject) {

        myState = ((ConcreteSubject)subject).getState();


    }
}
