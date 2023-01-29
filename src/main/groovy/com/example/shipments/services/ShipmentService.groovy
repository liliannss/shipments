package com.example.shipments.services

import com.example.shipments.models.Details
import com.example.shipments.models.Shipment
import com.example.shipments.models.Header
import com.example.shipments.models.HeaderLote
import com.example.shipments.models.Trailer
import com.example.shipments.models.TrailerLote
import org.springframework.stereotype.Service

@Service
class ShipmentService {

    static Shipment dummyShipment() {
        Shipment shipment = new Shipment()
        shipment.setHeaders(createHeaders())
        shipment.setHeaderLotes(createHeaderLotes())
        shipment.setDetails(createDetails())
        shipment.setTrailerLotes(createTrailerLotes())
        shipment.setTrailers(createTrailers())
        shipment
    }

    private static List<Header> createHeaders() {
        [
                new Header(id: "1", headerName: "HEADER", headerIdentifier: 1),
                new Header(id: "2", headerName: "HEADER", headerIdentifier: 2)
        ]
    }

    private static List<HeaderLote> createHeaderLotes() {
       [
                new HeaderLote(id: "1", headerLoteName: "HEADER_LOTE", headerLoteIdentifier: 1),
                new HeaderLote(id: "2", headerLoteName: "HEADER_LOTE", headerLoteIdentifier: 2)
        ]
    }

    private static List<Details> createDetails() {
        [
                new Details(id: "1", detailsName: "DETAILS", detailsIdentifier: 1),
                new Details(id: "2", detailsName: "DETAILS", detailsIdentifier: 2),
                new Details(id: "3", detailsName: "DETAILS", detailsIdentifier: 3)
        ]
    }

    private static List<TrailerLote> createTrailerLotes() {
        [
                new TrailerLote(id: "1", trailerLoteName: "TRAILER_LOTE", trailerLoteIdentifier: 1),
                new TrailerLote(id: "2", trailerLoteName: "TRAILER_LOTE", trailerLoteIdentifier: 2)
        ]
    }

    private static List<Trailer> createTrailers() {
       [
                new Trailer(id: "1", trailerName: "TRAILER", trailerIdentifier: 1),
                new Trailer(id: "2", trailerName: "TRAILER", trailerIdentifier: 2)
        ]
    }
}