// Autogenerated from Pigeon (v22.7.2), do not edit directly.
// See also: https://pub.dev/packages/pigeon
// ignore_for_file: public_member_api_docs, non_constant_identifier_names, avoid_as, unused_import, unnecessary_parenthesis, prefer_null_aware_operators, omit_local_variable_types, unused_shown_name, unnecessary_import, no_leading_underscores_for_local_identifiers

import 'dart:async';
import 'dart:typed_data' show Float64List, Int32List, Int64List, Uint8List;

import 'package:flutter/foundation.dart' show ReadBuffer, WriteBuffer;
import 'package:flutter/services.dart';

PlatformException _createConnectionError(String channelName) {
  return PlatformException(
    code: 'channel-error',
    message: 'Unable to establish connection on channel: "$channelName".',
  );
}

List<Object?> wrapResponse({Object? result, PlatformException? error, bool empty = false}) {
  if (empty) {
    return <Object?>[];
  }
  if (error == null) {
    return <Object?>[result];
  }
  return <Object?>[error.code, error.message, error.details];
}

/// Transport method of the signalr connection.
enum Transport {
  auto,
  serverSentEvents,
  longPolling,
}

/// SignalR connection status
enum ConnectionStatus {
  connecting,
  connected,
  reconnecting,
  disconnected,
  connectionSlow,
  connectionError,
}

class ConnectionOptions {
  ConnectionOptions({
    this.baseUrl,
    this.hubName,
    this.queryString,
    this.hubMethods,
    this.headers,
    this.transport,
  });

  String? baseUrl;

  String? hubName;

  String? queryString;

  List<String?>? hubMethods;

  Map<String?, String?>? headers;

  Transport? transport;

  Object encode() {
    return <Object?>[
      baseUrl,
      hubName,
      queryString,
      hubMethods,
      headers,
      transport,
    ];
  }

  static ConnectionOptions decode(Object result) {
    result as List<Object?>;
    return ConnectionOptions(
      baseUrl: result[0] as String?,
      hubName: result[1] as String?,
      queryString: result[2] as String?,
      hubMethods: (result[3] as List<Object?>?)?.cast<String?>(),
      headers: (result[4] as Map<Object?, Object?>?)?.cast<String?, String?>(),
      transport: result[5] as Transport?,
    );
  }
}

class StatusChangeResult {
  StatusChangeResult({
    this.connectionId,
    this.status,
    this.errorMessage,
  });

  String? connectionId;

  ConnectionStatus? status;

  String? errorMessage;

  Object encode() {
    return <Object?>[
      connectionId,
      status,
      errorMessage,
    ];
  }

  static StatusChangeResult decode(Object result) {
    result as List<Object?>;
    return StatusChangeResult(
      connectionId: result[0] as String?,
      status: result[1] as ConnectionStatus?,
      errorMessage: result[2] as String?,
    );
  }
}

class _PigeonCodec extends StandardMessageCodec {
  const _PigeonCodec();
  @override
  void writeValue(WriteBuffer buffer, Object? value) {
    if (value is int) {
      buffer.putUint8(4);
      buffer.putInt64(value);
    } else if (value is Transport) {
      buffer.putUint8(129);
      writeValue(buffer, value.index);
    } else if (value is ConnectionStatus) {
      buffer.putUint8(130);
      writeValue(buffer, value.index);
    } else if (value is ConnectionOptions) {
      buffer.putUint8(131);
      writeValue(buffer, value.encode());
    } else if (value is StatusChangeResult) {
      buffer.putUint8(132);
      writeValue(buffer, value.encode());
    } else {
      super.writeValue(buffer, value);
    }
  }

  @override
  Object? readValueOfType(int type, ReadBuffer buffer) {
    switch (type) {
      case 129:
        final int? value = readValue(buffer) as int?;
        return value == null ? null : Transport.values[value];
      case 130:
        final int? value = readValue(buffer) as int?;
        return value == null ? null : ConnectionStatus.values[value];
      case 131:
        return ConnectionOptions.decode(readValue(buffer)!);
      case 132:
        return StatusChangeResult.decode(readValue(buffer)!);
      default:
        return super.readValueOfType(type, buffer);
    }
  }
}

class SignalRHostApi {
  /// Constructor for [SignalRHostApi].  The [binaryMessenger] named argument is
  /// available for dependency injection.  If it is left null, the default
  /// BinaryMessenger will be used which routes to the host platform.
  SignalRHostApi({BinaryMessenger? binaryMessenger, String messageChannelSuffix = ''})
      : pigeonVar_binaryMessenger = binaryMessenger,
        pigeonVar_messageChannelSuffix =
            messageChannelSuffix.isNotEmpty ? '.$messageChannelSuffix' : '';
  final BinaryMessenger? pigeonVar_binaryMessenger;

  static const MessageCodec<Object?> pigeonChannelCodec = _PigeonCodec();

  final String pigeonVar_messageChannelSuffix;

  Future<String> connect(ConnectionOptions connectionOptions) async {
    final String pigeonVar_channelName =
        'dev.flutter.pigeon.signalr_flutter.SignalRHostApi.connect$pigeonVar_messageChannelSuffix';
    final BasicMessageChannel<Object?> pigeonVar_channel = BasicMessageChannel<Object?>(
      pigeonVar_channelName,
      pigeonChannelCodec,
      binaryMessenger: pigeonVar_binaryMessenger,
    );
    final List<Object?>? pigeonVar_replyList =
        await pigeonVar_channel.send(<Object?>[connectionOptions]) as List<Object?>?;
    if (pigeonVar_replyList == null) {
      throw _createConnectionError(pigeonVar_channelName);
    } else if (pigeonVar_replyList.length > 1) {
      throw PlatformException(
        code: pigeonVar_replyList[0]! as String,
        message: pigeonVar_replyList[1] as String?,
        details: pigeonVar_replyList[2],
      );
    } else if (pigeonVar_replyList[0] == null) {
      throw PlatformException(
        code: 'null-error',
        message: 'Host platform returned null value for non-null return value.',
      );
    } else {
      return (pigeonVar_replyList[0] as String?)!;
    }
  }

  Future<String> reconnect() async {
    final String pigeonVar_channelName =
        'dev.flutter.pigeon.signalr_flutter.SignalRHostApi.reconnect$pigeonVar_messageChannelSuffix';
    final BasicMessageChannel<Object?> pigeonVar_channel = BasicMessageChannel<Object?>(
      pigeonVar_channelName,
      pigeonChannelCodec,
      binaryMessenger: pigeonVar_binaryMessenger,
    );
    final List<Object?>? pigeonVar_replyList = await pigeonVar_channel.send(null) as List<Object?>?;
    if (pigeonVar_replyList == null) {
      throw _createConnectionError(pigeonVar_channelName);
    } else if (pigeonVar_replyList.length > 1) {
      throw PlatformException(
        code: pigeonVar_replyList[0]! as String,
        message: pigeonVar_replyList[1] as String?,
        details: pigeonVar_replyList[2],
      );
    } else if (pigeonVar_replyList[0] == null) {
      throw PlatformException(
        code: 'null-error',
        message: 'Host platform returned null value for non-null return value.',
      );
    } else {
      return (pigeonVar_replyList[0] as String?)!;
    }
  }

  Future<void> stop() async {
    final String pigeonVar_channelName =
        'dev.flutter.pigeon.signalr_flutter.SignalRHostApi.stop$pigeonVar_messageChannelSuffix';
    final BasicMessageChannel<Object?> pigeonVar_channel = BasicMessageChannel<Object?>(
      pigeonVar_channelName,
      pigeonChannelCodec,
      binaryMessenger: pigeonVar_binaryMessenger,
    );
    final List<Object?>? pigeonVar_replyList = await pigeonVar_channel.send(null) as List<Object?>?;
    if (pigeonVar_replyList == null) {
      throw _createConnectionError(pigeonVar_channelName);
    } else if (pigeonVar_replyList.length > 1) {
      throw PlatformException(
        code: pigeonVar_replyList[0]! as String,
        message: pigeonVar_replyList[1] as String?,
        details: pigeonVar_replyList[2],
      );
    } else {
      return;
    }
  }

  Future<bool> isConnected() async {
    final String pigeonVar_channelName =
        'dev.flutter.pigeon.signalr_flutter.SignalRHostApi.isConnected$pigeonVar_messageChannelSuffix';
    final BasicMessageChannel<Object?> pigeonVar_channel = BasicMessageChannel<Object?>(
      pigeonVar_channelName,
      pigeonChannelCodec,
      binaryMessenger: pigeonVar_binaryMessenger,
    );
    final List<Object?>? pigeonVar_replyList = await pigeonVar_channel.send(null) as List<Object?>?;
    if (pigeonVar_replyList == null) {
      throw _createConnectionError(pigeonVar_channelName);
    } else if (pigeonVar_replyList.length > 1) {
      throw PlatformException(
        code: pigeonVar_replyList[0]! as String,
        message: pigeonVar_replyList[1] as String?,
        details: pigeonVar_replyList[2],
      );
    } else if (pigeonVar_replyList[0] == null) {
      throw PlatformException(
        code: 'null-error',
        message: 'Host platform returned null value for non-null return value.',
      );
    } else {
      return (pigeonVar_replyList[0] as bool?)!;
    }
  }

  Future<String> invokeMethod(String methodName, List<String?> arguments) async {
    final String pigeonVar_channelName =
        'dev.flutter.pigeon.signalr_flutter.SignalRHostApi.invokeMethod$pigeonVar_messageChannelSuffix';
    final BasicMessageChannel<Object?> pigeonVar_channel = BasicMessageChannel<Object?>(
      pigeonVar_channelName,
      pigeonChannelCodec,
      binaryMessenger: pigeonVar_binaryMessenger,
    );
    final List<Object?>? pigeonVar_replyList =
        await pigeonVar_channel.send(<Object?>[methodName, arguments]) as List<Object?>?;
    if (pigeonVar_replyList == null) {
      throw _createConnectionError(pigeonVar_channelName);
    } else if (pigeonVar_replyList.length > 1) {
      throw PlatformException(
        code: pigeonVar_replyList[0]! as String,
        message: pigeonVar_replyList[1] as String?,
        details: pigeonVar_replyList[2],
      );
    } else if (pigeonVar_replyList[0] == null) {
      throw PlatformException(
        code: 'null-error',
        message: 'Host platform returned null value for non-null return value.',
      );
    } else {
      return (pigeonVar_replyList[0] as String?)!;
    }
  }
}

abstract class SignalRPlatformApi {
  static const MessageCodec<Object?> pigeonChannelCodec = _PigeonCodec();

  Future<void> onStatusChange(StatusChangeResult statusChangeResult);

  Future<void> onNewMessage(String hubName, String message);

  static void setUp(
    SignalRPlatformApi? api, {
    BinaryMessenger? binaryMessenger,
    String messageChannelSuffix = '',
  }) {
    messageChannelSuffix = messageChannelSuffix.isNotEmpty ? '.$messageChannelSuffix' : '';
    {
      final BasicMessageChannel<Object?> pigeonVar_channel = BasicMessageChannel<Object?>(
          'dev.flutter.pigeon.signalr_flutter.SignalRPlatformApi.onStatusChange$messageChannelSuffix',
          pigeonChannelCodec,
          binaryMessenger: binaryMessenger);
      if (api == null) {
        pigeonVar_channel.setMessageHandler(null);
      } else {
        pigeonVar_channel.setMessageHandler((Object? message) async {
          assert(message != null,
              'Argument for dev.flutter.pigeon.signalr_flutter.SignalRPlatformApi.onStatusChange was null.');
          final List<Object?> args = (message as List<Object?>?)!;
          final StatusChangeResult? arg_statusChangeResult = (args[0] as StatusChangeResult?);
          assert(arg_statusChangeResult != null,
              'Argument for dev.flutter.pigeon.signalr_flutter.SignalRPlatformApi.onStatusChange was null, expected non-null StatusChangeResult.');
          try {
            await api.onStatusChange(arg_statusChangeResult!);
            return wrapResponse(empty: true);
          } on PlatformException catch (e) {
            return wrapResponse(error: e);
          } catch (e) {
            return wrapResponse(error: PlatformException(code: 'error', message: e.toString()));
          }
        });
      }
    }
    {
      final BasicMessageChannel<Object?> pigeonVar_channel = BasicMessageChannel<Object?>(
          'dev.flutter.pigeon.signalr_flutter.SignalRPlatformApi.onNewMessage$messageChannelSuffix',
          pigeonChannelCodec,
          binaryMessenger: binaryMessenger);
      if (api == null) {
        pigeonVar_channel.setMessageHandler(null);
      } else {
        pigeonVar_channel.setMessageHandler((Object? message) async {
          assert(message != null,
              'Argument for dev.flutter.pigeon.signalr_flutter.SignalRPlatformApi.onNewMessage was null.');
          final List<Object?> args = (message as List<Object?>?)!;
          final String? arg_hubName = (args[0] as String?);
          assert(arg_hubName != null,
              'Argument for dev.flutter.pigeon.signalr_flutter.SignalRPlatformApi.onNewMessage was null, expected non-null String.');
          final String? arg_message = (args[1] as String?);
          assert(arg_message != null,
              'Argument for dev.flutter.pigeon.signalr_flutter.SignalRPlatformApi.onNewMessage was null, expected non-null String.');
          try {
            await api.onNewMessage(arg_hubName!, arg_message!);
            return wrapResponse(empty: true);
          } on PlatformException catch (e) {
            return wrapResponse(error: e);
          } catch (e) {
            return wrapResponse(error: PlatformException(code: 'error', message: e.toString()));
          }
        });
      }
    }
  }
}
