package com.bearhunting.cameraholder.component;

import java.sql.Types;
import org.hibernate.dialect.PostgreSQL94Dialect;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;


/**
 * ClassName:PgDialect
 * Package:com.bearhunting.cameraholder.component
 * Description:
 * @date:2020/3/23 13:24
 * @author:lvlele@bearhunting.cn
 */
public class PgDialect extends PostgreSQL94Dialect {
  @Override
  public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
    switch (sqlTypeDescriptor.getSqlType()) {
      case Types.CLOB:
        return VarcharTypeDescriptor.INSTANCE;
      case Types.BLOB:
        return VarcharTypeDescriptor.INSTANCE;
      case 1111:
        return VarcharTypeDescriptor.INSTANCE;
    }
    return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
  }

  public PgDialect() {
    super();
    registerHibernateType(1111, "string");
  }
}
