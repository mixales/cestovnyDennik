<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <title>Cestovný denník</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="static/css/jquery.timepicker.min.css">

    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="static/js/jquery.timepicker.min.js"></script>
</head>
<body>

    <div class="container">
        <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
            <h5 class="my-0 mr-md-auto font-weight-normal">Cestovný denník</h5>
            <nav class="my-2 my-md-0 mr-md-3">
                <a class="p-2 text-dark" href="/">Domov</a>
                <a class="p-2 text-dark" href="/newRecord">Pridať záznam</a>
            </nav>
        </div>
    </div>

    <c:choose>
        <c:when test="${mode == 'MODE_HOME'}">

            <div class="container">
                <div class="my-3 p-3 bg-white rounded shadow-sm">
                    <h6 class="border-bottom border-gray pb-2 mb-0">Cestovné záznamy</h6>

                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <th>Dátum</th>
                                <th>Vozidlo</th>
                                <th>Štart</th>
                                <th></th>
                                <th>Cieľ</th>
                                <th></th>
                                <th>Práca</th>
                                <th>Vzdialenosť</th>
                                <th>Náhrady</th>
                                <th></th>
                                <th></th>
                            </thead>
                            <tbody>
                            <c:forEach var="travelRecord" items="${travelRecords}">
                                <tr>
                                    <td>${travelRecord.datum}</td>
                                    <td>${travelRecord.vozidlo}</td>
                                    <td>${travelRecord.cesta_start}</td>
                                    <td>${travelRecord.cas_start}</td>
                                    <td>${travelRecord.cesta_ciel}</td>
                                    <td>${travelRecord.cas_ciel}</td>
                                    <td>${travelRecord.cas_praca_zaciatok} - ${travelRecord.cas_praca_koniec}</td>
                                    <td>${travelRecord.vzdialenost}</td>
                                    <td>${travelRecord.nahrada}</td>
                                    <td><a href="/editRecord?id=${travelRecord.id}"><i class="fas fa-edit"></i></a></td>
                                    <td><a href="/deleteRecord?id=${travelRecord.id}"><i class="fas fa-trash-alt"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>

            <div class="container">
                <div class="my-3 p-3 bg-white rounded shadow-sm">
                    <h6 class="border-bottom border-gray pb-2 mb-0">Informácie o cestových príkazoch</h6>

                    <div class="row mt-3 mb-3 text-center">
                        <div class="col-md-3">
                            <button type="button" class="btn btn-primary">
                                Počet záznamov <span class="badge badge-light">${celkove}</span>
                            </button>
                        </div>

                        <div class="col-md-3">
                            <button type="button" class="btn btn-primary">
                                Kilometrov celkovo <span class="badge badge-light">${kilometre}</span>
                            </button>
                        </div>

                        <div class="col-md-3">
                            <button type="button" class="btn btn-info">
                                Kilometre (tento rok) <span class="badge badge-light">${kilometre_rok}</span>
                            </button>
                        </div>

                        <div class="col-md-3">
                            <button type="button" class="btn btn-info">
                                Náhrady (tento rok) <span class="badge badge-light">${nahrady_rok}</span>
                            </button>
                        </div>
                    </div>

                </div>
            </div>

        </c:when>
        <c:when test="${mode == 'MODE_NEW' || mode == 'MODE_EDIT'}">

            <div class="container">

                <c:choose>
                    <c:when test="${mode == 'MODE_NEW'}">
                        <h3 class="text-center">Pridať cestovný záznam</h3>
                    </c:when>
                    <c:when test="${mode == 'MODE_EDIT'}">
                        <h3 class="text-center">Upraviť cestovný záznam</h3>
                    </c:when>
                </c:choose>

                <hr>
                <form class="form-horizontal" method="post" action="/saveRecord">
                    <input type="hidden" name="id" value="${travelRecord.id}" />

                    <div class="form-group row">
                        <label for="datepicker" class="col-form-label col-md-3">Dátum</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="datepicker" name="datum" value="${datumNF}"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="vozidlo" class="col-form-label col-md-3">Vozidlo</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" id="vozidlo" name="vozidlo" value="${travelRecord.vozidlo}"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="cesta_start" class="col-form-label col-md-3">Štart</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="cesta_start" name="cesta_start" value="${travelRecord.cesta_start}"/>
                        </div>
                        <div class="col-md-2">
                            <input type="text" class="form-control" name="cas_start" value="${travelRecord.cas_start}" id="timepick1" placeholder="Čas" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="cesta_ciel" class="col-form-label col-md-3">Cieľ</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="cesta_ciel" name="cesta_ciel" value="${travelRecord.cesta_ciel}"/>
                        </div>
                        <div class="col-md-2">
                            <input type="text" class="form-control" name="cas_ciel" value="${travelRecord.cas_ciel}" id="timepick2" placeholder="Čas" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="cas_prace_zaciatok" class="col-form-label col-md-3">Práca</label>
                        <div class="col-md-2">
                            <input type="text" id="timepick3" class="form-control" id="cas_prace_zaciatok" name="cas_praca_zaciatok" value="${travelRecord.cas_praca_zaciatok}" placeholder="Začiatok"/>
                        </div>
                        <div class="col-md-2">
                            <input type="text" id="timepick4" class="form-control" name="cas_praca_koniec" value="${travelRecord.cas_praca_koniec}" placeholder="Koniec" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="vzdialenost" class="col-form-label col-md-3">Vzdialenosť</label>
                        <div class="col-md-2">
                            <input type="text" class="form-control" name="vzdialenost" id="vzdialenost" value="${travelRecord.vzdialenost}" placeholder="km" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="spotreba" class="col-form-label col-md-3">Spotreba l/100km</label>
                        <div class="col-md-2">
                            <input type="text" class="form-control" id="spotreba" name="spotreba" value="${travelRecord.spotreba}" placeholder="11.5" value="11.5" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="palivo_cena" class="col-form-label col-md-3">Cena paliva/l</label>

                        <div class="col-md-2">
                            <input type="text" class="form-control" id="palivo_cena" name="palivo_cena" value="${travelRecord.palivo_cena}" placeholder="1.375" value="1.375" />
                        </div>
                    </div>

                    <div class="text-center">
                            <input type="submit" class="btn btn-primary" value="Uložiť" />
                    </div>

                </form>
            </div>

        </c:when>
    </c:choose>

    <div class="container">
        <footer class="col-lg-12 mt-4 border-top">
            <div class="text-center">
                <div>Copyright &copy; 2019 | Michal Hraška</div>
            </div>
        </footer>
    </div>

    <script>
        $( function() {
            $("#datepicker").datepicker({ 'dateFormat': 'mm/dd/yy'});
            $('#timepick1').timepicker({ 'timeFormat': 'H:i:s' });
            $('#timepick2').timepicker({ 'timeFormat': 'H:i:s' });
            $('#timepick3').timepicker({ 'timeFormat': 'H:i:s' });
            $('#timepick4').timepicker({ 'timeFormat': 'H:i:s' });
        } );
    </script>

</body>
</html>