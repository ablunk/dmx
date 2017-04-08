package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

public interface ElementResolver<C> {
	/**
	 * resolves all elements matching the given identifier in the given context.
	 * 
	 * @param identifier
	 * @param context
	 * @return
	 */
	Collection<IdentifiedElement> resolve(String identifier, C context);
}
