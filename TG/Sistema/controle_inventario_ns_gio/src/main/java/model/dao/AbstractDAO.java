/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Tiago
 */
public abstract class AbstractDAO implements IDAO{
    protected Connection conn;
    protected boolean ctrlTransacao;
    protected PreparedStatement stmt = null;
    protected ResultSet rs = null;
}
