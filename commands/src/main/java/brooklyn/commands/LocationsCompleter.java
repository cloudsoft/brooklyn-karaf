/*
 * Copyright 2014 by Cloudsoft Corporation Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package brooklyn.commands;

import java.util.List;
import java.util.Set;

import org.apache.karaf.shell.console.Completer;
import org.apache.karaf.shell.console.completer.StringsCompleter;

public abstract class LocationsCompleter implements Completer {

    protected final StringsCompleter delegate = new StringsCompleter();
    protected Set<String> cache;

    @Override
    public int complete(String buffer, int cursor, List<String> candidates) {
        delegate.getStrings().clear();
        for (String item : cache) {
            if (buffer == null || item.startsWith(buffer)) {
                delegate.getStrings().add(item);
            }
        }

        return delegate.complete(buffer, cursor, candidates);
    }

}