// Autogenerated from Pigeon (v1.0.19), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.example.flutterkmmtest1.pigeons;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression"})
public class Pigeon {

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class Pizza {
    private @NonNull String name;
    public @NonNull String getName() { return name; }
    public void setName(@NonNull String setterArg) {
      if (setterArg == null) {
        throw new IllegalStateException("Nonnull field \"name\" is null.");
      }
      this.name = setterArg;
    }

    private @NonNull Long id;
    public @NonNull Long getId() { return id; }
    public void setId(@NonNull Long setterArg) {
      if (setterArg == null) {
        throw new IllegalStateException("Nonnull field \"id\" is null.");
      }
      this.id = setterArg;
    }

    /** Constructor is private to enforce null safety; use Builder. */
    private Pizza() {}
    public static class Builder {
      private @Nullable String name;
      public @NonNull Builder setName(@NonNull String setterArg) {
        this.name = setterArg;
        return this;
      }
      private @Nullable Long id;
      public @NonNull Builder setId(@NonNull Long setterArg) {
        this.id = setterArg;
        return this;
      }
      public @NonNull Pizza build() {
        Pizza pigeonReturn = new Pizza();
        pigeonReturn.setName(name);
        pigeonReturn.setId(id);
        return pigeonReturn;
      }
    }
    @NonNull Map<String, Object> toMap() {
      Map<String, Object> toMapResult = new HashMap<>();
      toMapResult.put("name", name);
      toMapResult.put("id", id);
      return toMapResult;
    }
    static @NonNull Pizza fromMap(@NonNull Map<String, Object> map) {
      Pizza pigeonResult = new Pizza();
      Object name = map.get("name");
      pigeonResult.setName((String)name);
      Object id = map.get("id");
      pigeonResult.setId((id == null) ? null : ((id instanceof Integer) ? (Integer)id : (Long)id));
      return pigeonResult;
    }
  }

  public interface Result<T> {
    void success(T result);
    void error(Throwable error);
  }
  private static class PizzaHostApiCodec extends StandardMessageCodec {
    public static final PizzaHostApiCodec INSTANCE = new PizzaHostApiCodec();
    private PizzaHostApiCodec() {}
    @Override
    protected Object readValueOfType(byte type, ByteBuffer buffer) {
      switch (type) {
        case (byte)128:         
          return Pizza.fromMap((Map<String, Object>) readValue(buffer));
        
        default:        
          return super.readValueOfType(type, buffer);
        
      }
    }
    @Override
    protected void writeValue(ByteArrayOutputStream stream, Object value)     {
      if (value instanceof Pizza) {
        stream.write(128);
        writeValue(stream, ((Pizza) value).toMap());
      } else 
{
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter.*/
  public interface PizzaHostApi {
    void getPizzas(Result<List<Pizza>> result);

    /** The codec used by PizzaHostApi. */
    static MessageCodec<Object> getCodec() {
      return PizzaHostApiCodec.INSTANCE;
    }

    /** Sets up an instance of `PizzaHostApi` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, PizzaHostApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.PizzaHostApi.getPizzas", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              Result<List<Pizza>> resultCallback = new Result<List<Pizza>>() {
                public void success(List<Pizza> result) {
                  wrapped.put("result", result);
                  reply.reply(wrapped);
                }
                public void error(Throwable error) {
                  wrapped.put("error", wrapError(error));
                  reply.reply(wrapped);
                }
              };

              api.getPizzas(resultCallback);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
              reply.reply(wrapped);
            }
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
  private static class PizzaNavigationApiCodec extends StandardMessageCodec {
    public static final PizzaNavigationApiCodec INSTANCE = new PizzaNavigationApiCodec();
    private PizzaNavigationApiCodec() {}
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter.*/
  public interface PizzaNavigationApi {
    void navigateToPage3(Result<Void> result);

    /** The codec used by PizzaNavigationApi. */
    static MessageCodec<Object> getCodec() {
      return PizzaNavigationApiCodec.INSTANCE;
    }

    /** Sets up an instance of `PizzaNavigationApi` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, PizzaNavigationApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.PizzaNavigationApi.navigateToPage3", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              Result<Void> resultCallback = new Result<Void>() {
                public void success(Void result) {
                  wrapped.put("result", null);
                  reply.reply(wrapped);
                }
                public void error(Throwable error) {
                  wrapped.put("error", wrapError(error));
                  reply.reply(wrapped);
                }
              };

              api.navigateToPage3(resultCallback);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
              reply.reply(wrapped);
            }
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
  private static Map<String, Object> wrapError(Throwable exception) {
    Map<String, Object> errorMap = new HashMap<>();
    errorMap.put("message", exception.toString());
    errorMap.put("code", exception.getClass().getSimpleName());
    errorMap.put("details", "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    return errorMap;
  }
}
