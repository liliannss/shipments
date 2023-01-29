package com.example.shipments.services

import com.example.shipments.configs.FileConfig
import com.example.shipments.models.*
import com.github.javafaker.Faker
import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Service

@Service
class FileService {

    static FileConfig fileConfig
    static ShipmentService shipmentService

    FileService(FileConfig fileConfig, ShipmentService shipmentService) {
        this.fileConfig = fileConfig
        this.shipmentService = shipmentService
    }

    static processFile() {
        Shipment shipment = shipmentService.dummyShipment()
        fileConfig.setup(new Faker().name().fullName().toLowerCase())

        try {
            if (!shipment.headers.isEmpty()) {

                List<Header> headers = shipment.headers
                List<HeaderLote> headerLotes = shipment.headerLotes
                List<Details> details = shipment.details
                List<TrailerLote> trailerLotes = shipment.trailerLotes
                List<Trailer> trailers = shipment.trailers

                for (int count = 0; count < headers.size(); count++) {
                    formatHeader(headers[count])
                    writerHeader(headers[count])

                    formatHeaderLote(headerLotes[count])
                    writerHeaderLote(headerLotes[count])

                    formatDetails(details[count])
                    writerDetails(details[count])

                    formatTrailerLote(trailerLotes[count])
                    writerTrailerLote(trailerLotes[count])

                    formatTrailer(trailers[count])
                    writerTrailer(trailers[count])
                }
                fileConfig.flush()
            }
        } catch (IOException ex) {
            fileConfig.close()
        }
    }

    private static void writerHeader(Header header) {
        fileConfig.writer(header.id + header.headerName + header.headerIdentifier)
    }

    private static void writerHeaderLote(HeaderLote headerLote) {
        fileConfig.writer(headerLote.id + headerLote.headerLoteName + headerLote.headerLoteIdentifier)
    }

    private static void writerDetails(Details details) {
        fileConfig.writer(details.id + details.detailsName + details.detailsIdentifier)
    }

    private static void writerTrailerLote(TrailerLote trailerLote) {
        fileConfig.writer(trailerLote.id + trailerLote.trailerLoteName + trailerLote.trailerLoteIdentifier)
    }

    private static void writerTrailer(Trailer trailer) {
        fileConfig.writer(trailer.id + trailer.trailerName + trailer.trailerIdentifier)
    }

    static def formatHeader(Header header) {
        header.setId(StringUtils.rightPad(header.getId(), 2, " "))
        header.setHeaderName(StringUtils.rightPad(header.getHeaderName(), 4, " "))
        header.setHeaderIdentifier(StringUtils.rightPad(header.getHeaderIdentifier(), 10, " "))
    }

    static def formatHeaderLote(HeaderLote headerLote) {
        headerLote.setId(StringUtils.rightPad(headerLote.getId(), 2, " "))
        headerLote.setHeaderLoteName(StringUtils.rightPad(headerLote.getHeaderLoteName(), 4, " "))
        headerLote.setHeaderLoteIdentifier(StringUtils.rightPad(headerLote.getHeaderLoteIdentifier(), 10, " "))
    }

    static def formatDetails(Details details) {
        details.setId(StringUtils.rightPad(details.getId(), 12, " "))
        details.setDetailsName(StringUtils.rightPad(details.getDetailsName(), 28, " "))
        details.setDetailsIdentifier(StringUtils.rightPad(details.getDetailsIdentifier(), 32, " "))
    }

    static def formatTrailerLote(TrailerLote trailerLote) {
        trailerLote.setId(StringUtils.rightPad(trailerLote.getId(), 8, " "))
        trailerLote.setTrailerLoteName(StringUtils.rightPad(trailerLote.getTrailerLoteName(), 22, " "))
        trailerLote.setTrailerLoteIdentifier(StringUtils.rightPad(trailerLote.getTrailerLoteIdentifier(), 34, " "))
    }

    static def formatTrailer(Trailer trailer) {
        trailer.setId(StringUtils.rightPad(trailer.getId(), 8, " "))
        trailer.setTrailerName(StringUtils.rightPad(trailer.getTrailerName(), 22, " "))
        trailer.setTrailerIdentifier(StringUtils.rightPad(trailer.getTrailerIdentifier(), 34, " "))
    }

}