/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.gemfire;

import com.gemstone.gemfire.GemFireCheckedException;
import com.gemstone.gemfire.GemFireException;
import com.gemstone.gemfire.cache.Region;

/**
 * Callback interface for GemFire code. To be used with {@link GemfireTemplate}'s execution methods, often as anonymous
 * classes within a method implementation. A typical implementation will call Region.get/put/query to perform some
 * operations on stored objects. 
 * 
 * @author Costin Leau
 */
public interface GemfireCallback<T> {

	/**
	 * Gets called by {@link GemfireTemplate#execute(GemfireCallback)}. Does not need to care about handling transactions
	 * or exceptions.
	 * <p/>
	 * Allows for returning a result object created within the callback, i.e. a domain object or a collection of domain
	 * objects. A thrown custom RuntimeException is treated as an application exception: It gets propagated to the caller
	 * of the template.
	 *  
	 * @param region GemFire Region
	 * @return a result object, or <tt>null</tt> if none
	 */
	@SuppressWarnings("unchecked")
	T doInGemfire(Region region) throws GemFireCheckedException, GemFireException;
}
