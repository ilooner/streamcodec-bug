/**
 * Put your copyright and license info here.
 */
package com.streamcodec;

import com.datatorrent.api.Context.PortContext;
import org.apache.hadoop.conf.Configuration;

import com.datatorrent.api.annotation.ApplicationAnnotation;
import com.datatorrent.api.StreamingApplication;
import com.datatorrent.api.DAG;
import com.datatorrent.api.DAG.Locality;
import com.datatorrent.lib.codec.KryoSerializableStreamCodec;
import com.datatorrent.lib.io.ConsoleOutputOperator;

@ApplicationAnnotation(name="MyFirstApplication")
public class Application implements StreamingApplication
{
  @Override
  public void populateDAG(DAG dag, Configuration conf)
  {
    RandomNumberGenerator randomGenerator = dag.addOperator("randomGenerator", RandomNumberGenerator.class);
    randomGenerator.setNumTuples(500);
    RandomNumberGenerator randomGenerator1 = dag.addOperator("randomGenerator1", RandomNumberGenerator.class);
    randomGenerator.setNumTuples(500);
    RandomNumberGenerator randomGenerator2 = dag.addOperator("randomGenerator2", RandomNumberGenerator.class);
    randomGenerator.setNumTuples(500);

    SinkOperator sink = dag.addOperator("sink", SinkOperator.class);

    dag.getMeta(sink).getMeta(sink.input1).getAttributes().put(PortContext.STREAM_CODEC, new KryoSerializableStreamCodec());
    dag.getMeta(sink).getMeta(sink.input2).getAttributes().put(PortContext.STREAM_CODEC, new DoubleStreamCodec());

    dag.addStream("rand", randomGenerator.out, sink.input);
    dag.addStream("rand1", randomGenerator1.out, sink.input1);
    dag.addStream("rand2", randomGenerator2.out, sink.input2);
  }
}
