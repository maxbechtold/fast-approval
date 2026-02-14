package com.github.approval.sesame;

import com.github.approval.Approval;
import org.junit.Test;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.util.Values;

import java.nio.file.Paths;

public class GraphApprovalExample {
    @Test
    public void graphVerificationExample() {

        ModelBuilder builder = new ModelBuilder();
        // populate our graph with statements (maybe from GraphQueryResult?)
        builder.subject(Values.iri("http://example.org/subject")).add(Values.iri("http://example.org/predicate"), Values.literal("example"));
        Model graph = builder.build();

        // Note: this is still thread safe...
        Approval<Model> graphApproval = Approval.of(Model.class)
                .withConverter(new GraphConverter())
                .withReporter(GraphReporter.getInstance())
                .build();

        // Verify the graph, change the path accordingly
        graphApproval.verify(graph, Paths.get("graph-result.dot"));
    }
}
