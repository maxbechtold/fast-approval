package com.github.approval.sesame;

/*
 * #%L
 * approval-sesame
 * %%
 * Copyright (C) 2014 Nikolavp
 * %%
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
 * #L%
 */


import com.github.approval.Approval;
import com.github.approval.Approvals;
import org.junit.Test;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.util.Values;

import java.nio.file.Paths;

public class GraphReporterIT {
    @Test
    public void shouldProperlyConvertTheDotFormatAndThenReportItInConfigredApplication() throws Exception {

        ModelBuilder builder = new ModelBuilder();
        builder.subject(Values.iri("http://test.urn")).add(Values.iri("http://predicate"), Values.literal("Test label"));
        builder.subject(Values.iri("http://test.urn1")).add(Values.iri("http://predicate1"), Values.literal("Test label1"));
        Model graph = builder.build();

        Approval<Model> approval = Approval.of(Model.class)
                .withConverter(new GraphConverter())
                .withReporter(GraphReporter.getInstance())
                .build();
        approval.verify(graph, Paths.get("src/test/resources/approvals/shouldProperlyConvertTheDotFormatAndThenReportItInConfigredApplication.dot"));
    }
}
