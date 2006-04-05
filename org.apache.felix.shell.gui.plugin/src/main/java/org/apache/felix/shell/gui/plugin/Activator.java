/*
 *   Copyright 2006 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.apache.felix.shell.gui.plugin;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
    private BundleContext m_context = null;

    public void start(BundleContext context)
    {
        m_context = context;

        // Register the bundle list plugin.
        m_context.registerService(
            org.apache.felix.shell.gui.Plugin.class.getName(),
            new BundleListPlugin(m_context), null);

        // Register the shell plugin.
        m_context.registerService(
            org.apache.felix.shell.gui.Plugin.class.getName(),
            new ShellPlugin(m_context), null);

        // Register the OBR plugin.
        m_context.registerService(
            org.apache.felix.shell.gui.Plugin.class.getName(),
            new OBRPlugin(m_context), null);
    }

    public void stop(BundleContext context)
    {
    }
}