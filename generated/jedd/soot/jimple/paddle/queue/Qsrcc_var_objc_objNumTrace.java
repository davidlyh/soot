package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public final class Qsrcc_var_objc_objNumTrace extends Qsrcc_var_objc_obj {
    public Qsrcc_var_objc_objNumTrace(String name) { super(name); }
    
    private LinkedList readers = new LinkedList();
    
    public void add(Context _srcc, VarNode _var, Context _objc, AllocNode _obj) {
        Rsrcc_var_objc_obj.Tuple in = new Rsrcc_var_objc_obj.Tuple(_srcc, _var, _objc, _obj);
        for (Iterator it = readers.iterator(); it.hasNext(); ) {
            Rsrcc_var_objc_objNumTrace reader = (Rsrcc_var_objc_objNumTrace) it.next();
            reader.add(in);
        }
    }
    
    public void add(final jedd.internal.RelationContainer in) { throw new RuntimeException(); }
    
    public Rsrcc_var_objc_obj reader(String rname) {
        Rsrcc_var_objc_obj ret = new Rsrcc_var_objc_objNumTrace(name + ":" + rname);
        readers.add(ret);
        return ret;
    }
}