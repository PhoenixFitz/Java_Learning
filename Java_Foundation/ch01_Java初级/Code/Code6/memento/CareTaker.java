package com.klaus.memento;

/**
 * 负责人
 * 负责管理备忘录对象
 */
public class CareTaker {
    private EmpMemento memento;
    //	private List<EmpMemento> list = new ArrayList<EmpMemento>();



    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
