package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Robjc_obj_varc_varMerge extends Robjc_obj_varc_var {
    void add(final jedd.internal.RelationContainer tuple) { throw new RuntimeException(); }
    
    private Robjc_obj_varc_var in1;
    
    private Robjc_obj_varc_var in2;
    
    public Robjc_obj_varc_varMerge(Robjc_obj_varc_var in1, Robjc_obj_varc_var in2) {
        super(in1.name + "+" + in2.name);
        this.in1 = in1;
        this.in2 = in2;
    }
    
    public Iterator iterator() {
        ;
        final Iterator it1 = in1.iterator();
        final Iterator it2 = in2.iterator();
        return new Iterator() {
            public boolean hasNext() { return it1.hasNext() || it2.hasNext(); }
            
            public Object next() {
                if (it1.hasNext()) return it1.next();
                return it2.next();
            }
            
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        return new jedd.internal.RelationContainer(new Attribute[] { objc.v(), varc.v(), obj.v(), var.v() },
                                                   new PhysicalDomain[] { C2.v(), C1.v(), H1.v(), V1.v() },
                                                   ("return jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().r" +
                                                    "ead(in1.get()), in2.get()); at /home/olhotak/soot-trunk/src/" +
                                                    "soot/jimple/paddle/queue/Robjc_obj_varc_varMerge.jedd:52,8-1" +
                                                    "4"),
                                                   jedd.internal.Jedd.v().union(jedd.internal.Jedd.v().read(in1.get()),
                                                                                in2.get()));
    }
    
    public boolean hasNext() { return in1.hasNext() || in2.hasNext(); }
}