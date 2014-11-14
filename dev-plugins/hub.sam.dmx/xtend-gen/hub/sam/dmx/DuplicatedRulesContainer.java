package hub.sam.dmx;

import hub.sam.dbl.TsRule;
import java.util.Collection;
import java.util.HashSet;
import org.eclipse.emf.ecore.EClass;

@SuppressWarnings("all")
public class DuplicatedRulesContainer {
  public Collection<TsRule> rules = new HashSet<TsRule>();
  
  public EClass metaClass;
}
