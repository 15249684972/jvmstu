package cn.wk.mysql;

import org.hibernate.dialect.MySQL5InnoDBDialect;  

    public class MySQL5DialectUTF8 extends MySQL5InnoDBDialect{  

        @Override  
        public String getTableTypeString() {  
            return "ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8";    
        }  
    } 