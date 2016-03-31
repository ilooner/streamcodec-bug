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
    // Sample DAG with 2 operators
    // Replace this code with the DAG you want to build

    RandomNumberGenerator randomGenerator = dag.addOperator("randomGenerator", RandomNumberGenerator.class);
    PassThroughOperator passThrough = dag.addOperator("passthrough", PassThroughOperator.class);

    randomGenerator.setNumTuples(500);

    SinkOperator cons = dag.addOperator("console", new SinkOperator());

    dag.getMeta(passThrough).getMeta(passThrough.input).getAttributes().put(PortContext.STREAM_CODEC, new KryoSerializableStreamCodec());

    dag.addStream("passthrough", randomGenerator.out, passThrough.input);
    dag.addStream("randomData", passThrough.output, cons.input);
  }
}
