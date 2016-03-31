/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.streamcodec;

import com.datatorrent.api.StreamCodec;
import com.datatorrent.lib.appdata.gpo.GPOUtils;
import com.datatorrent.netlet.util.Slice;
import java.io.Serializable;
import org.apache.commons.lang3.mutable.MutableInt;

public class DoubleStreamCodec implements StreamCodec<Double>, Serializable
{
  private static final long serialVersionUID = 201603310124L;

  public DoubleStreamCodec()
  {
  }

  @Override
  public Double fromByteArray(Slice fragment)
  {
    return GPOUtils.deserializeDouble(fragment.buffer, new MutableInt(0));
  }

  @Override
  public Slice toByteArray(Double o)
  {
    byte[] array = GPOUtils.serializeDouble(o);

    return new Slice(array, 0, array.length);
  }

  @Override
  public int getPartition(Double o)
  {
    return o.hashCode();
  }
}
