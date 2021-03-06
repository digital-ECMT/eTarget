package org.digitalecmt.etarget.dao;

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

import org.digitalecmt.etarget.config.TargetConfiguration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EditLockDAOTest {
	
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setUpClass() {
		try {
			context = new AnnotationConfigApplicationContext(TargetConfiguration.class);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInsert() {
		EditLockDAO editLock = context.getBean(EditLockDAO.class);
		Boolean success=editLock.lock("anja.leblanc@apps.idecide.science", 2);
		assertTrue(success);
		Boolean locked=editLock.isLocked("anja.leblanc@apps.idecide.science", 2);
		assertFalse(locked);
		locked=editLock.isLocked("anja@bindrich.de", 2);
		assertTrue(locked);
		String locker = editLock.getLocker(2);
		assertTrue(locker.compareTo("anja.leblanc@apps.idecide.science")==0);
		success=editLock.lock("richard.hoskins@apps.idecide.science", 2);
		assertFalse(success);
		success=editLock.lock("anja.leblanc@manchester.ac.uk", 2);
		assertFalse(success);
		success=editLock.lock("abc@apps.idecide.science", 2);
		assertFalse(success);
		editLock.unlock("anja.leblanc@apps.idecide.science", 2);
		locked=editLock.isLocked("anja.leblanc@apps.idecide.science", 2);
		assertFalse(locked);
		locked=editLock.isLocked("anja@bindrich.de", 2);
		assertFalse(locked);
	}
	
	@Test
	public void multiInsert() {
		EditLockDAO editLock = context.getBean(EditLockDAO.class);
		Boolean success=editLock.lock("anja.leblanc@apps.idecide.science", 2);
		assertTrue(success);
		success=editLock.lock("anja.leblanc@apps.idecide.science", 3);
		assertTrue(success);
		success=editLock.lock("anja.leblanc@apps.idecide.science", 4);
		assertTrue(success);
		Boolean locked=editLock.isLocked("anja@bindrich.de", 2);
		assertTrue(locked);
		locked=editLock.isLocked("anja@bindrich.de", 3);
		assertTrue(locked);
		locked=editLock.isLocked("anja@bindrich.de", 4);
		assertTrue(locked);
		editLock.unlockAll("anja.leblanc@apps.idecide.science");
		locked=editLock.isLocked("anja@bindrich.de", 2);
		assertFalse(locked);
		locked=editLock.isLocked("anja@bindrich.de", 3);
		assertFalse(locked);
		locked=editLock.isLocked("anja@bindrich.de", 4);
		assertFalse(locked);
	}

}
