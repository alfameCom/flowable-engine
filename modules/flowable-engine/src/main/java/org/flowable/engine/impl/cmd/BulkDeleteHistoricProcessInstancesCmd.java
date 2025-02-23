/* Licensed under the Apache License, Version 2.0 (the "License");
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

package org.flowable.engine.impl.cmd;

import java.io.Serializable;
import java.util.Collection;

import org.flowable.common.engine.api.FlowableIllegalArgumentException;
import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.impl.util.CommandContextUtil;

public class BulkDeleteHistoricProcessInstancesCmd implements Command<Object>, Serializable {

    private static final long serialVersionUID = 1L;
    protected Collection<String> processInstanceIds;

    public BulkDeleteHistoricProcessInstancesCmd(Collection<String> processInstanceIds) {
        this.processInstanceIds = processInstanceIds;
    }

    @Override
    public Object execute(CommandContext commandContext) {
        if (processInstanceIds == null) {
            throw new FlowableIllegalArgumentException("processInstanceIds is null");
        }
        
        CommandContextUtil.getHistoryManager(commandContext).recordBulkDeleteProcessInstances(processInstanceIds);

        return null;
    }

}
