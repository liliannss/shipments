package com.example.shipments.models

class Shipment {

    List<Header> headers
    List<HeaderLote> headerLotes
    List<Details> details
    List<TrailerLote> trailerLotes
    List<Trailer> trailers
}