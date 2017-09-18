<contents>

  <!--- サイドメニュー -->
  <div class="col-sm-3" style="padding-top: 1em">
    <div id="menu" class="list-group">
      <a href="#menu1" type="button" class="list-group-item list-group-item-action {active: menu === 'menu1'}"><i class="fa fa-address-book-o pr-3"></i>メニュー1</a>
      <a href="#menu2" type="button" class="list-group-item list-group-item-action {active: menu === 'menu2'}"><i class="fa fa-bomb pr-3"></i>メニュー2</a>
      <a href="#menu3" type="button" class="list-group-item list-group-item-action {active: menu === 'menu3'}"><i class="fa fa-id-card pr-3"></i>メニュー3</a>
    </div>
  </div>
  
  <!-- メインページ -->
  <div class="col-sm-9" >
    <page1 if={menu === 'menu1'}></page1>
    <page2 if={menu === 'menu2'}></page2>
    <page3 if={menu === 'menu3'}></page3>
  </div>
  
  <script>
    
    require('./page1/page1.tag');
    require('./page2/page2.tag');
    require('./page3/page3.tag');
    
    let self = this;
    self.menu = 'menu1';
    
    // ルータ設定
    let url = location.protocol + '//' + location.host + location.pathname;
    let router = new Navigo(null, true);
    router.on({
      'menu1': () => { self.menu = 'menu1'; self.update(); },
      'menu2': () => { self.menu = 'menu2'; self.update(); },
      'menu3': () => { self.menu = 'menu3'; self.update(); }
    });
    router.notFound((query) => {console.log('xxx');});
    router.resolve();
    
    
  </script>
  
</contents>
