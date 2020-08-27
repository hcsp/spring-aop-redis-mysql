
package com.github.hcsp.cache;

import java.io.Serializable;

public class CacheValue implements Serializable {
  private Object result;
  private long processTime;

  public CacheValue(Object result, long processTime) {
    this.result = result;
    this.processTime = processTime;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  public long getProcessTime() {
    return processTime;
  }

  public void setProcessTime(long processTime) {
    this.processTime = processTime;
  }
}
