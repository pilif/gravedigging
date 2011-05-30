(function($){
  var applet = null;
  var addApplet = function(){
    $('<applet codebase="." id="grave" code="ch.gnegg.Zombie" width="1" height="1" archive="grave.jar"><param name="caller" value="$__caller"><param name="zombie_resurrected" value="$__zombie_loaded"></applet>')
      .appendTo('body');
  };
  window.$__caller = function(thisobj, arg, cb){
    cb.apply(thisobj || window, [arg]);
  };
  window.$__zombie_loaded = function(){
    applet = $('#grave')[0];
    FileReader.prototype._notifyClients();
    FileReader.prototype._runPending();
  };
  window.FileReader = FileReader = function(){
    this.grave = null;
  };

  FileReader.prototype._notify = [];
  FileReader.prototype._pending = [];
  FileReader.prototype.readFile = function(file, callback){
    if (applet){
      applet.dig(file, null, function(contents){
        callback(this, contents);
      });
      return;
    }
    addApplet();
    FileReader.prototype._pending[FileReader.prototype._pending.length] =
      [function(){
        applet.dig(file, null, function(contents){
          callback(this, contents);
        });
      }, this];
  };
  FileReader.prototype.apiReady = function(callback){
    if (applet){
      // no loading happened, not notifying clients
      return;
    }
    FileReader.prototype._notify[FileReader.prototype._notify.length] =
      [function(){ callback(this); }, this]
  };
  FileReader.prototype._notifyClients = function(){
    var i = 0;
    for(i = 0; i < FileReader.prototype._notify.length; i++){
      FileReader.prototype._notify[i][0].apply(FileReader.prototype._notify[i][1]);
    }
    FileReader.prototype._notify = [];
  };
  FileReader.prototype._runPending = function(){
    var i = 0;
    for(i = 0; i < FileReader.prototype._pending.length; i++){
      FileReader.prototype._pending[i][0].apply(FileReader.prototype._pending[i][1]);
    }
    FileReader.prototype._pending = [];
  }
})(jQuery);