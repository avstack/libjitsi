/*
 * Copyright @ 2015 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jitsi.impl.libjitsi;

import java.util.*;
import org.osgi.framework.*;

/**
 * Represents an implementation of the <tt>libjitsi</tt> library which utilizes
 * OSGi.
 *
 * @author Lyubomir Marinov
 */
public class LibJitsiOSGiImpl
    extends LibJitsiImpl
{
    /**
     * The <tt>BundleContext</tt> discovered by this instance during its
     * initialization and used to look for registered services.
     */
    private final BundleContext bundleContext;

    /**
     * Initializes a new <tt>LibJitsiOSGiImpl</tt> instance with a specific
     * <tt>BundleContext</tt>.
     *
     * @param bundleContext the <tt>BundleContext</tt> to be used by the new
     * instance to look for registered services
     */
    public LibJitsiOSGiImpl(BundleContext bundleContext)
    {
        this.bundleContext =
            Objects.requireNonNull(bundleContext, "bundleContext");
    }

    /**
     * Gets a service of a specific type associated with this implementation of
     * the <tt>libjitsi</tt> library.
     *
     * @param serviceClass the type of the service to be retrieved
     * @return a service of the specified type if there is such an association
     * known to this implementation of the <tt>libjitsi</tt> library; otherwise,
     * <tt>null</tt>
     */
    @Override
    protected <T> T getService(Class<T> serviceClass)
    {
        ServiceReference<T> serviceReference
            = bundleContext.getServiceReference(serviceClass);
        T service
            = (serviceReference == null)
                ? null
                : bundleContext.getService(serviceReference);

        if (service == null)
            service = super.getService(serviceClass);

        return service;
    }
}
