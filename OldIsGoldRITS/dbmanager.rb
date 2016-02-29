require 'mysql2'
require 'json'
require './config'
require 'iconv'

class DB_Manager

	def open_connection
		@@mysql_client = Mysql2::Client.new(:host => Db_config.db_server, :username => Db_config.username, :password => Db_config.password, :database => Db_config.db_name)
	end

	def get_inventory(barcode)
		open_connection
		inventory_items = Array.new
		inventory_query = @@mysql_client.query("SELECT sku, artist, title, quality,quantity, price from INVENTORY left join ALBUM on INVENTORY.album_id = ALBUM.album_id where sku = #{barcode}", :as=>:array)
        inventory_query.each do |row|
        	inventory_items << {:sku=>row[0],:artist=>row[1],:title=>row[2],:quality=>row[3],:price=>row[4], :quantity=>row[5]}
        end
        
        return inventory_items[0].to_json
		@@mysql_client.close()
	end
		
		
end
