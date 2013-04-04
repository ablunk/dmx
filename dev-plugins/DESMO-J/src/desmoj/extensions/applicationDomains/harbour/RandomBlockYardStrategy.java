package desmoj.extensions.applicationDomains.harbour;

import desmoj.core.dist.IntDistUniform;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.ModelComponent;

/**
 * The RandomBlockYardStrategy presents the strategy that is used by the
 * <code>Yard</code> to find a certain block to store/retrieve a container by
 * the following way: the random block will be selected. RandomBlockYardStrategy
 * impements <code>ChooseBlockYardStrategy</code>.
 * 
 * @see ChooseBlockYardStrategy
 * @see ModelComponent
 * 
 * @version DESMO-J, Ver. 2.2.0 copyright (c) 2010
 * @author Eugenia Neufeld
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
public class RandomBlockYardStrategy extends ModelComponent implements
		ChooseBlockYardStrategy {
	/**
	 * Constructs the RandomBlockYardStrategy for a yard.
	 * 
	 * @param owner
	 *            desmoj.Model : The model this RandomBlockYardStrategy is
	 *            associated to.
	 */
	public RandomBlockYardStrategy(Model owner) {

		super(owner, "RandomBlockYardStrategy"); // make a ModelComponent
	}

	/**
	 * This method describes the RandomBlockYardStrategy that is used by the
	 * yard and returns the random selected block.
	 * 
	 * @param blocks
	 *            <code>Block</code>[] : The array of the blocks.
	 * @return <code>Block</code>[] : the found block.
	 */
	public Block getBlock(Block[] blocks) {

		// get the number of blocks
		int nBlocks = blocks.length;

		// if there aren't any blocks
		if (nBlocks == 0)
			return null;

		// if there's only one block
		if (nBlocks == 1)

			return blocks[0]; // return this block

		else // there're some blocks
		{
			IntDistUniform rg = new IntDistUniform(getModel(), "", 1, nBlocks,
					false, false);

			// get random position of the block
			int pos = (int) (rg.sample() - 1);

			return blocks[pos];
		}
	}
}