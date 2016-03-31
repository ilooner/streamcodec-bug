/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.streamcodec;

import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.DefaultOutputPort;
import com.datatorrent.api.StreamCodec;
import com.datatorrent.common.util.BaseOperator;
import com.datatorrent.lib.codec.KryoSerializableStreamCodec;

public class PassThroughOperator extends BaseOperator
{
  public final transient DefaultInputPort<Object> input = new DefaultInputPort<Object>()
  {
    @Override
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public void process(Object t)
    {
      output.emit(t);
    }
  };

  public final transient DefaultOutputPort<Object> output = new DefaultOutputPort<Object>()
  {
  };

  public PassThroughOperator()
  {
  }
}
