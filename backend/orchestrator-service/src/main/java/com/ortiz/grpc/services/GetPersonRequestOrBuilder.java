// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data-service.proto

package com.ortiz.grpc.services;

public interface GetPersonRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:services.GetPersonRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string tenantId = 1;</code>
   * @return The tenantId.
   */
  String getTenantId();
  /**
   * <code>string tenantId = 1;</code>
   * @return The bytes for tenantId.
   */
  com.google.protobuf.ByteString
      getTenantIdBytes();

  /**
   * <code>string personId = 2;</code>
   * @return The personId.
   */
  String getPersonId();
  /**
   * <code>string personId = 2;</code>
   * @return The bytes for personId.
   */
  com.google.protobuf.ByteString
      getPersonIdBytes();
}