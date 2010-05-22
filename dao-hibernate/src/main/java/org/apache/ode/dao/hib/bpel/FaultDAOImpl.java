/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.ode.dao.hib.bpel;

import java.io.IOException;

import javax.xml.namespace.QName;

import org.apache.ode.dao.bpel.FaultDAO;
import org.apache.ode.dao.hib.SessionManager;
import org.apache.ode.dao.hib.bpel.hobj.HFaultData;
import org.apache.ode.utils.DOMUtils;
import org.apache.ode.utils.QNameUtils;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * Hibernate based {@link FaultDAO} implementation
 */
public class FaultDAOImpl extends HibernateDao implements FaultDAO {


    HFaultData _self;

    public FaultDAOImpl(SessionManager sm, HFaultData fault) {
        super(sm, fault);
        entering("FaultDAOImpl.FaultDAOImpl");
        _self = fault;
    }

    public QName getName() {
        return QNameUtils.toQName(_self.getName());
    }

    public Element getData() {
        entering("FaultDAOImpl.getData");
        if (_self.getData() == null) return null;
        try {
            return DOMUtils.stringToDOM(_self.getData());
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getExplanation() {
        return _self.getExplanation();
    }

    public int getLineNo() {
        return _self.getLineNo();
    }

    public int getActivityId() {
        return _self.getActivityId();
    }
}