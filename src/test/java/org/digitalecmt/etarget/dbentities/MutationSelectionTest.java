package org.digitalecmt.etarget.dbentities;

/*-
 * #%L
 * eTarget Maven Webapp
 * %%
 * Copyright (C) 2017 - 2021 digital ECMT
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import static org.junit.Assert.*;

import org.digitalecmt.etarget.MutationSelection;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MutationSelectionTest {

	@Test
	public void test1() {
		MutationSelection ms = new MutationSelection("anja.leblanc@apps.idecide.science", "2", "1", "CTDNA");
		String result=ms.addData();
		System.out.println("MutationSelection add result " + result);
		assertTrue(result.compareTo("{\"success\":\"true\"}")==0);
	}
	@Test
	public void test2() {
		MutationSelection ms = new MutationSelection("anja.leblanc@apps.idecide.science", "2", "1", "CTDNA");
		String result=ms.removeData();
		System.out.println("MutationSelection add result " + result);
		assertTrue(result.compareTo("{\"success\":\"true\"}")==0);
	}
}
