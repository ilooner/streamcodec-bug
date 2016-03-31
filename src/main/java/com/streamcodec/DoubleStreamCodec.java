/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.streamcodec;

import com.datatorrent.api.StreamCodec;
import com.datatorrent.lib.appdata.gpo.GPOUtils;
import com.datatorrent.netlet.util.Slice;
import com.streamcodec.RandomNumberGenerator.Complex;
import java.io.Serializable;
import org.apache.commons.lang3.mutable.MutableInt;

public class DoubleStreamCodec implements StreamCodec<Complex>, Serializable
{
  private static final long serialVersionUID = 201603310124L;

  public DoubleStreamCodec()
  {
  }

  @Override
  public Complex fromByteArray(Slice fragment)
  {
    return new Complex(GPOUtils.deserializeDouble(fragment.buffer, new MutableInt(0)));
  }

  @Override
  public Slice toByteArray(Complex o)
  {
    byte[] array = GPOUtils.serializeDouble(o.val);

    return new Slice(array, 0, array.length);
  }

  @Override
  public int getPartition(Complex o)
  {
    return o.hashCode();
  }
}
