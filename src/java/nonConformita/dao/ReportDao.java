/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.dao;

import java.util.List;
import nonConformita.model.Report;

/**
 *
 * @author FSEVERI\lucangeli3503
 */
public interface ReportDao {
    Report findByCodiceNC(int codiceNC);
    void saveReport(Report report);
    void deleteReport(int codiceNC);
    List<Report> findAllReports();
}
