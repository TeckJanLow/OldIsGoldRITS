class Db_config
    @@user="bongo"
    @@pass="abcd1234"
    @@db="bongo_records"
    @@host="bongo-records.cvd1ck22zwym.ap-southeast-2.rds.amazonaws.com"

    def initialize
        puts "Configuration initialized."
    end

    def self.username
        return  @@user
    end

    def self.password
        return @@pass
    end

    def self.db_server
        return @@host
    end

    def self.db_name
        return @@db
    end
end

