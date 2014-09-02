package hub.sam.dmx;

import hub.sam.dbl.TsRule;
import java.util.Collection;
import java.util.HashSet;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class DuplicatedRulesContainer {
  public Collection<TsRule> rules = new Function0<Collection<TsRule>>() {
    public Collection<TsRule> apply() {
      HashSet<TsRule> _hashSet = new HashSet<TsRule>();
      return _hashSet;
    }
  }.apply();
  
  public EClass metaClass;
}
