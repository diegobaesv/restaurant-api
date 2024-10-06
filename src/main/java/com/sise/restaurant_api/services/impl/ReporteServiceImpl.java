package com.sise.restaurant_api.services.impl;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;
import java.util.List;
import com.itextpdf.html2pdf.HtmlConverter;
import com.sise.restaurant_api.payload.requests.ReporteCabeceraRequest;
import com.sise.restaurant_api.payload.requests.ReporteMaestroRequest;
import com.sise.restaurant_api.payload.requests.ReporteTablaRequest;
import com.sise.restaurant_api.services.IReporteService;
import com.sise.restaurant_api.shared.Constants;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ReporteServiceImpl implements IReporteService{

    @Override
    public byte[] reporteMaestro(ReporteMaestroRequest reporteMaestroRequest) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(new StringBuilder()
                                    .append("<!DOCTYPE html>")
                                    .append("<html>")
                                        .append("<head>")
                                            .append("<style>")
                                                .append(buildCSS())
                                            .append("</style>")
                                        .append("</head>")
                                        .append("<body>")
                                            .append(buildFechaImpresion())
                                            .append(buildHeaderReporte())
                                            .append(buildTituloReporte(reporteMaestroRequest.getTituloReporte()))
                                            .append(buildCabeceraReporte(reporteMaestroRequest.getCabeceras()))
                                            .append(buildTablaReporte(reporteMaestroRequest.getTabla()))
                                        .append("</body>")
                                    .append("</html>")
                                    .toString(), 
            byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private String buildFechaImpresion(){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "<p>Fecha impresión: "+fechaHoraActual.format(formato)+"</p>";
    }

    private String buildHeaderReporte(){
        return new StringBuilder()
            .append("<div class=\"header-pdf\">")
                .append("<img src=\"data:image/png;base64, "+Constants.LOGO_B64+"\"></img>")
                .append("<div class=\"titulos\">")
                    .append("<h1>Restaurante Tengo Hambre's</h1>")
                    .append("<h3>Direccion: Av Arequipa 2020 - Santa Beatriz</h3>")
                .append("</div>")
            .append("</div>")
            .toString();
    }

    private String buildTituloReporte(String titulo){
        return new StringBuilder()
            .append("<h2 class=\"titulo-reporte\">")
                .append(titulo)
            .append("</h2>")
            .toString();
    }

    private String buildCabeceraReporte(List<ReporteCabeceraRequest> reporteCabeceraRequests){
        if(reporteCabeceraRequests == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb
        .append("<table class=\"cabeceras-reporte\"><tbody>")
        .append("<tr>");
        for (int i = 0; i < reporteCabeceraRequests.size(); i++) {
            if(i%3==0){
                sb
                .append("</tr>")
                .append("<tr>");
            }
            sb
            .append("<td>")
                .append("<p>")
                    .append("<b>")
                        .append(reporteCabeceraRequests.get(i).getCampo()+": ")
                    .append("</b>")
                    .append(reporteCabeceraRequests.get(i).getContenido())
                .append("</p>")
            .append("</td>");
        }
        sb
        .append("</tr>")
        .append("</tbody></table>");
        return sb.toString();
    }

    private String buildTablaReporte(ReporteTablaRequest reporteTablaRequest){
        if(reporteTablaRequest == null) {
            return "<p>No hay datos</p>";
        }

        StringBuilder sb = new StringBuilder();
        sb
        .append("<table class=\"tabla-data\">")
        .append("<thead><tr>");
        if(reporteTablaRequest.getCabeceras() != null){
            for (String cabera : reporteTablaRequest.getCabeceras()) {
                sb
                .append("<th>")
                    .append(cabera)
                .append("</th>");
            }
        }

        sb
        .append("</tr></thead>")
        .append("<tbody>");

        if(reporteTablaRequest.getData() != null){
            for (List<String> datas : reporteTablaRequest.getData()) {
                sb.append("<tr>");
                for (String data : datas) {
                    sb
                    .append("<td>")
                        .append(data)
                    .append("</td>");
                }
                sb.append("</tr>");
            }
        }

        sb
        .append("</tbody>")
        .append("</table>");
        return sb.toString();
    }

    private String buildCSS(){

        return new StringBuilder()

            .append("@page {")
                .append("size: A4;")
                .append("@bottom-right: {")
                    .append("content: \"Página \" counter(page) \" de \" counter(pages);")
                .append("}")    
            .append("}")

            .append("body {")
                .append("font-family: helvetica;")
            .append("}")

            .append(".header-pdf {")
                .append("background-color: "+Constants.PRIMARY_COLOR_REPORT+";")
                .append("border-radius: 10px;")
                .append("padding: 20px;")
                .append("display: flex;")
                .append("flex-direction: row;")
                .append("align-items: center;")
            .append("}")

            .append(".header-pdf h1 {")
                .append("color: white;")
                .append("text-align: center;")
                .append("margin: 0px;")
                .append("margin-top: 6px;")
            .append("}")

            .append(".header-pdf h3 {")
                .append("color: white;")
                .append("text-align: center;")
                .append("margin: 0px;")
                .append("font-weight: normal;")
            .append("}")

            .append(".header-pdf .titulos {")
                .append("width:100%;")
            .append("}")

            .append(".header-pdf img {")
                .append("width: 150px;")
                .append("height: 150px;")
                .append("text-align: center;")
            .append("}")


            .append("h2.titulo-reporte {")
                .append("border: 5px "+Constants.PRIMARY_COLOR_REPORT+" solid;")
                .append("border-radius: 10px;")
                .append("text-align: center;")
                .append("color: "+Constants.PRIMARY_COLOR_REPORT+";")
                .append("padding: 10px;")
            .append("}")

            .append(".cabeceras-reporte {")
                .append("width: 100%;")
                .append("border-collapse: separate;")   
                .append("border-spacing: 0;")   
                .append("border: 3px black solid;")
                .append("border-radius: 10px;")
            .append("}")

            .append(".cabeceras-reporte p {")
                .append("margin: 0px;")
                .append("margin-top: 5px;")
            .append("}")

            .append(".tabla-data {")
                .append("padding: 5px;")
                .append("border-collapse: separate;")   
                .append("border-spacing: 0;")   
                .append("width: 100%;")
                .append("margin-top: 20px;")
            .append("}")

            .append(".tabla-data th {")
                .append("border-bottom: 2px black solid;")
                .append("border-top: 2px black solid;")
                .append("background-color: #c4c4c4;")
            .append("}")

            .append(".tabla-data td {")
                .append("border-bottom: 2px black solid;")
            .append("}")

            .append(".tabla-data thead tr {")
                .append("font-weight: bold;")
            .append("}")

            .append(".tabla-data tr:first-child th:first-child {")
                .append("border-top-left-radius: 10px;")
            .append("}")

            .append(".tabla-data tr:first-child th:last-child {")
                .append("border-top-right-radius: 10px;")
            .append("}")

            .append(".tabla-data tr:last-child td:first-child {")
                .append("border-bottom-left-radius: 10px;")
            .append("}")

            .append(".tabla-data tr:last-child td:last-child{")
                .append("border-bottom-right-radius: 10px;")
            .append("}")


            .append(".tabla-data * td:first-child , .tabla-data * th:first-child {")
                .append("border-left: 2px black solid;")
            .append("}")

            .append(".tabla-data * td:last-child , .tabla-data * th:last-child {")
                .append("border-right: 2px black solid;")
            .append("}")

            .toString();
    }
    
}
