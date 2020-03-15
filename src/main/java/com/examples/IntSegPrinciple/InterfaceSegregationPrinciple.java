//you should not put anything into your interface more than a client asked you to
package com.examples.IntSegPrinciple;

class Document {

}
interface Machine {
    void print(Document d);
    void fax (Document d);
    void scan (Document d);
}

interface  Printer {
    void print(Document d);
}

interface  fax {
    void fax(Document d);
}
interface  scan {
    void scan(Document d);
}
//YAGNI = You ain't gonna need it

class MultiFunctionPrinter implements Machine{

    @Override
    public void print(Document d) {
        //
    }

    @Override
    public void fax(Document d) {
        //
    }

    @Override
    public void scan(Document d) {
        //
    }
}
class OldFashionedPrinter implements Machine {

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

class oldFashionPrinterUpdate implements  Printer{

    @Override
    public void print(Document d) {
        //
    }
}

class multiFunctionPrinter implements Printer, scan {

    @Override
    public void print(Document d) {
        //
    }

    @Override
    public void scan(Document d) {
        //
    }
}

interface newMultiFunctionPrinter extends Printer, scan { }

class getMultiFunctionPrinter implements  newMultiFunctionPrinter{

    @Override
    public void print(Document d) {
        //
    }

    @Override
    public void scan(Document d) {
//
    }
}
public class InterfaceSegregationPrinciple {
}
