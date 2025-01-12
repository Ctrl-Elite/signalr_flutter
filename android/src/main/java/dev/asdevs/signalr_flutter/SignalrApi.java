// Autogenerated from Pigeon (v22.7.2), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package dev.asdevs.signalr_flutter;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression", "serial"})
public class SignalrApi {

  /** Error class for passing custom error details to Flutter via a thrown PlatformException. */
  public static class FlutterError extends RuntimeException {

    /** The error code. */
    public final String code;

    /** The error details. Must be a datatype supported by the api codec. */
    public final Object details;

    public FlutterError(@NonNull String code, @Nullable String message, @Nullable Object details) 
    {
      super(message);
      this.code = code;
      this.details = details;
    }
  }

  @NonNull
  protected static ArrayList<Object> wrapError(@NonNull Throwable exception) {
    ArrayList<Object> errorList = new ArrayList<>(3);
    if (exception instanceof FlutterError) {
      FlutterError error = (FlutterError) exception;
      errorList.add(error.code);
      errorList.add(error.getMessage());
      errorList.add(error.details);
    } else {
      errorList.add(exception.toString());
      errorList.add(exception.getClass().getSimpleName());
      errorList.add(
        "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }
    return errorList;
  }

  @NonNull
  protected static FlutterError createConnectionError(@NonNull String channelName) {
    return new FlutterError("channel-error",  "Unable to establish connection on channel: " + channelName + ".", "");
  }

  @Target(METHOD)
  @Retention(CLASS)
  @interface CanIgnoreReturnValue {}

  /** Transport method of the signalr connection. */
  public enum Transport {
    AUTO(0),
    SERVER_SENT_EVENTS(1),
    LONG_POLLING(2);

    final int index;

    Transport(final int index) {
      this.index = index;
    }
  }

  /** SignalR connection status */
  public enum ConnectionStatus {
    CONNECTING(0),
    CONNECTED(1),
    RECONNECTING(2),
    DISCONNECTED(3),
    CONNECTION_SLOW(4),
    CONNECTION_ERROR(5);

    final int index;

    ConnectionStatus(final int index) {
      this.index = index;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class ConnectionOptions {
    private @Nullable String baseUrl;

    public @Nullable String getBaseUrl() {
      return baseUrl;
    }

    public void setBaseUrl(@Nullable String setterArg) {
      this.baseUrl = setterArg;
    }

    private @Nullable String hubName;

    public @Nullable String getHubName() {
      return hubName;
    }

    public void setHubName(@Nullable String setterArg) {
      this.hubName = setterArg;
    }

    private @Nullable String queryString;

    public @Nullable String getQueryString() {
      return queryString;
    }

    public void setQueryString(@Nullable String setterArg) {
      this.queryString = setterArg;
    }

    private @Nullable List<String> hubMethods;

    public @Nullable List<String> getHubMethods() {
      return hubMethods;
    }

    public void setHubMethods(@Nullable List<String> setterArg) {
      this.hubMethods = setterArg;
    }

    private @Nullable Map<String, String> headers;

    public @Nullable Map<String, String> getHeaders() {
      return headers;
    }

    public void setHeaders(@Nullable Map<String, String> setterArg) {
      this.headers = setterArg;
    }

    private @Nullable Transport transport;

    public @Nullable Transport getTransport() {
      return transport;
    }

    public void setTransport(@Nullable Transport setterArg) {
      this.transport = setterArg;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) { return true; }
      if (o == null || getClass() != o.getClass()) { return false; }
      ConnectionOptions that = (ConnectionOptions) o;
      return Objects.equals(baseUrl, that.baseUrl) && Objects.equals(hubName, that.hubName) && Objects.equals(queryString, that.queryString) && Objects.equals(hubMethods, that.hubMethods) && Objects.equals(headers, that.headers) && Objects.equals(transport, that.transport);
    }

    @Override
    public int hashCode() {
      return Objects.hash(baseUrl, hubName, queryString, hubMethods, headers, transport);
    }

    public static final class Builder {

      private @Nullable String baseUrl;

      @CanIgnoreReturnValue
      public @NonNull Builder setBaseUrl(@Nullable String setterArg) {
        this.baseUrl = setterArg;
        return this;
      }

      private @Nullable String hubName;

      @CanIgnoreReturnValue
      public @NonNull Builder setHubName(@Nullable String setterArg) {
        this.hubName = setterArg;
        return this;
      }

      private @Nullable String queryString;

      @CanIgnoreReturnValue
      public @NonNull Builder setQueryString(@Nullable String setterArg) {
        this.queryString = setterArg;
        return this;
      }

      private @Nullable List<String> hubMethods;

      @CanIgnoreReturnValue
      public @NonNull Builder setHubMethods(@Nullable List<String> setterArg) {
        this.hubMethods = setterArg;
        return this;
      }

      private @Nullable Map<String, String> headers;

      @CanIgnoreReturnValue
      public @NonNull Builder setHeaders(@Nullable Map<String, String> setterArg) {
        this.headers = setterArg;
        return this;
      }

      private @Nullable Transport transport;

      @CanIgnoreReturnValue
      public @NonNull Builder setTransport(@Nullable Transport setterArg) {
        this.transport = setterArg;
        return this;
      }

      public @NonNull ConnectionOptions build() {
        ConnectionOptions pigeonReturn = new ConnectionOptions();
        pigeonReturn.setBaseUrl(baseUrl);
        pigeonReturn.setHubName(hubName);
        pigeonReturn.setQueryString(queryString);
        pigeonReturn.setHubMethods(hubMethods);
        pigeonReturn.setHeaders(headers);
        pigeonReturn.setTransport(transport);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<>(6);
      toListResult.add(baseUrl);
      toListResult.add(hubName);
      toListResult.add(queryString);
      toListResult.add(hubMethods);
      toListResult.add(headers);
      toListResult.add(transport);
      return toListResult;
    }

    static @NonNull ConnectionOptions fromList(@NonNull ArrayList<Object> pigeonVar_list) {
      ConnectionOptions pigeonResult = new ConnectionOptions();
      Object baseUrl = pigeonVar_list.get(0);
      pigeonResult.setBaseUrl((String) baseUrl);
      Object hubName = pigeonVar_list.get(1);
      pigeonResult.setHubName((String) hubName);
      Object queryString = pigeonVar_list.get(2);
      pigeonResult.setQueryString((String) queryString);
      Object hubMethods = pigeonVar_list.get(3);
      pigeonResult.setHubMethods((List<String>) hubMethods);
      Object headers = pigeonVar_list.get(4);
      pigeonResult.setHeaders((Map<String, String>) headers);
      Object transport = pigeonVar_list.get(5);
      pigeonResult.setTransport((Transport) transport);
      return pigeonResult;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class StatusChangeResult {
    private @Nullable String connectionId;

    public @Nullable String getConnectionId() {
      return connectionId;
    }

    public void setConnectionId(@Nullable String setterArg) {
      this.connectionId = setterArg;
    }

    private @Nullable ConnectionStatus status;

    public @Nullable ConnectionStatus getStatus() {
      return status;
    }

    public void setStatus(@Nullable ConnectionStatus setterArg) {
      this.status = setterArg;
    }

    private @Nullable String errorMessage;

    public @Nullable String getErrorMessage() {
      return errorMessage;
    }

    public void setErrorMessage(@Nullable String setterArg) {
      this.errorMessage = setterArg;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) { return true; }
      if (o == null || getClass() != o.getClass()) { return false; }
      StatusChangeResult that = (StatusChangeResult) o;
      return Objects.equals(connectionId, that.connectionId) && Objects.equals(status, that.status) && Objects.equals(errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
      return Objects.hash(connectionId, status, errorMessage);
    }

    public static final class Builder {

      private @Nullable String connectionId;

      @CanIgnoreReturnValue
      public @NonNull Builder setConnectionId(@Nullable String setterArg) {
        this.connectionId = setterArg;
        return this;
      }

      private @Nullable ConnectionStatus status;

      @CanIgnoreReturnValue
      public @NonNull Builder setStatus(@Nullable ConnectionStatus setterArg) {
        this.status = setterArg;
        return this;
      }

      private @Nullable String errorMessage;

      @CanIgnoreReturnValue
      public @NonNull Builder setErrorMessage(@Nullable String setterArg) {
        this.errorMessage = setterArg;
        return this;
      }

      public @NonNull StatusChangeResult build() {
        StatusChangeResult pigeonReturn = new StatusChangeResult();
        pigeonReturn.setConnectionId(connectionId);
        pigeonReturn.setStatus(status);
        pigeonReturn.setErrorMessage(errorMessage);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<>(3);
      toListResult.add(connectionId);
      toListResult.add(status);
      toListResult.add(errorMessage);
      return toListResult;
    }

    static @NonNull StatusChangeResult fromList(@NonNull ArrayList<Object> pigeonVar_list) {
      StatusChangeResult pigeonResult = new StatusChangeResult();
      Object connectionId = pigeonVar_list.get(0);
      pigeonResult.setConnectionId((String) connectionId);
      Object status = pigeonVar_list.get(1);
      pigeonResult.setStatus((ConnectionStatus) status);
      Object errorMessage = pigeonVar_list.get(2);
      pigeonResult.setErrorMessage((String) errorMessage);
      return pigeonResult;
    }
  }

  private static class PigeonCodec extends StandardMessageCodec {
    public static final PigeonCodec INSTANCE = new PigeonCodec();

    private PigeonCodec() {}

    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte) 129: {
          Object value = readValue(buffer);
          return value == null ? null : Transport.values()[((Long) value).intValue()];
        }
        case (byte) 130: {
          Object value = readValue(buffer);
          return value == null ? null : ConnectionStatus.values()[((Long) value).intValue()];
        }
        case (byte) 131:
          return ConnectionOptions.fromList((ArrayList<Object>) readValue(buffer));
        case (byte) 132:
          return StatusChangeResult.fromList((ArrayList<Object>) readValue(buffer));
        default:
          return super.readValueOfType(type, buffer);
      }
    }

    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value) {
      if (value instanceof Transport) {
        stream.write(129);
        writeValue(stream, value == null ? null : ((Transport) value).index);
      } else if (value instanceof ConnectionStatus) {
        stream.write(130);
        writeValue(stream, value == null ? null : ((ConnectionStatus) value).index);
      } else if (value instanceof ConnectionOptions) {
        stream.write(131);
        writeValue(stream, ((ConnectionOptions) value).toList());
      } else if (value instanceof StatusChangeResult) {
        stream.write(132);
        writeValue(stream, ((StatusChangeResult) value).toList());
      } else {
        super.writeValue(stream, value);
      }
    }
  }


  /** Asynchronous error handling return type for non-nullable API method returns. */
  public interface Result<T> {
    /** Success case callback method for handling returns. */
    void success(@NonNull T result);

    /** Failure case callback method for handling errors. */
    void error(@NonNull Throwable error);
  }
  /** Asynchronous error handling return type for nullable API method returns. */
  public interface NullableResult<T> {
    /** Success case callback method for handling returns. */
    void success(@Nullable T result);

    /** Failure case callback method for handling errors. */
    void error(@NonNull Throwable error);
  }
  /** Asynchronous error handling return type for void API method returns. */
  public interface VoidResult {
    /** Success case callback method for handling returns. */
    void success();

    /** Failure case callback method for handling errors. */
    void error(@NonNull Throwable error);
  }
  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface SignalRHostApi {

    void connect(@NonNull ConnectionOptions connectionOptions, @NonNull Result<String> result);

    void reconnect(@NonNull Result<String> result);

    void stop(@NonNull VoidResult result);

    void isConnected(@NonNull Result<Boolean> result);

    void invokeMethod(@NonNull String methodName, @NonNull List<String> arguments, @NonNull Result<String> result);

    /** The codec used by SignalRHostApi. */
    static @NonNull MessageCodec<Object> getCodec() {
      return PigeonCodec.INSTANCE;
    }
    /**Sets up an instance of `SignalRHostApi` to handle messages through the `binaryMessenger`. */
    static void setUp(@NonNull BinaryMessenger binaryMessenger, @Nullable SignalRHostApi api) {
      setUp(binaryMessenger, "", api);
    }
    static void setUp(@NonNull BinaryMessenger binaryMessenger, @NonNull String messageChannelSuffix, @Nullable SignalRHostApi api) {
      messageChannelSuffix = messageChannelSuffix.isEmpty() ? "" : "." + messageChannelSuffix;
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.signalr_flutter.SignalRHostApi.connect" + messageChannelSuffix, getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList<Object>) message;
                ConnectionOptions connectionOptionsArg = (ConnectionOptions) args.get(0);
                Result<String> resultCallback =
                    new Result<String>() {
                      public void success(String result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                      }

                      public void error(Throwable error) {
                        ArrayList<Object> wrappedError = wrapError(error);
                        reply.reply(wrappedError);
                      }
                    };

                api.connect(connectionOptionsArg, resultCallback);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.signalr_flutter.SignalRHostApi.reconnect" + messageChannelSuffix, getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<>();
                Result<String> resultCallback =
                    new Result<String>() {
                      public void success(String result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                      }

                      public void error(Throwable error) {
                        ArrayList<Object> wrappedError = wrapError(error);
                        reply.reply(wrappedError);
                      }
                    };

                api.reconnect(resultCallback);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.signalr_flutter.SignalRHostApi.stop" + messageChannelSuffix, getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<>();
                VoidResult resultCallback =
                    new VoidResult() {
                      public void success() {
                        wrapped.add(0, null);
                        reply.reply(wrapped);
                      }

                      public void error(Throwable error) {
                        ArrayList<Object> wrappedError = wrapError(error);
                        reply.reply(wrappedError);
                      }
                    };

                api.stop(resultCallback);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.signalr_flutter.SignalRHostApi.isConnected" + messageChannelSuffix, getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<>();
                Result<Boolean> resultCallback =
                    new Result<Boolean>() {
                      public void success(Boolean result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                      }

                      public void error(Throwable error) {
                        ArrayList<Object> wrappedError = wrapError(error);
                        reply.reply(wrappedError);
                      }
                    };

                api.isConnected(resultCallback);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.signalr_flutter.SignalRHostApi.invokeMethod" + messageChannelSuffix, getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList<Object>) message;
                String methodNameArg = (String) args.get(0);
                List<String> argumentsArg = (List<String>) args.get(1);
                Result<String> resultCallback =
                    new Result<String>() {
                      public void success(String result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                      }

                      public void error(Throwable error) {
                        ArrayList<Object> wrappedError = wrapError(error);
                        reply.reply(wrappedError);
                      }
                    };

                api.invokeMethod(methodNameArg, argumentsArg, resultCallback);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
  /** Generated class from Pigeon that represents Flutter messages that can be called from Java. */
  public static class SignalRPlatformApi {
    private final @NonNull BinaryMessenger binaryMessenger;
    private final String messageChannelSuffix;

    public SignalRPlatformApi(@NonNull BinaryMessenger argBinaryMessenger) {
      this(argBinaryMessenger, "");
    }
    public SignalRPlatformApi(@NonNull BinaryMessenger argBinaryMessenger, @NonNull String messageChannelSuffix) {
      this.binaryMessenger = argBinaryMessenger;
      this.messageChannelSuffix = messageChannelSuffix.isEmpty() ? "" : "." + messageChannelSuffix;
    }

    /**
     * Public interface for sending reply.
     * The codec used by SignalRPlatformApi.
     */
    static @NonNull MessageCodec<Object> getCodec() {
      return PigeonCodec.INSTANCE;
    }
    public void onStatusChange(@NonNull StatusChangeResult statusChangeResultArg, @NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.signalr_flutter.SignalRPlatformApi.onStatusChange" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          new ArrayList<>(Collections.singletonList(statusChangeResultArg)),
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
    public void onNewMessage(@NonNull String hubNameArg, @NonNull String messageArg, @NonNull VoidResult result) {
      final String channelName = "dev.flutter.pigeon.signalr_flutter.SignalRPlatformApi.onNewMessage" + messageChannelSuffix;
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(
              binaryMessenger, channelName, getCodec());
      channel.send(
          new ArrayList<>(Arrays.asList(hubNameArg, messageArg)),
          channelReply -> {
            if (channelReply instanceof List) {
              List<Object> listReply = (List<Object>) channelReply;
              if (listReply.size() > 1) {
                result.error(new FlutterError((String) listReply.get(0), (String) listReply.get(1), listReply.get(2)));
              } else {
                result.success();
              }
            }  else {
              result.error(createConnectionError(channelName));
            } 
          });
    }
  }
}
