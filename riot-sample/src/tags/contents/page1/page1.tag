<page1>
  <div class="row">
    <div class="col-sm-12 pt-3 pb-3">
      <h3>××検索画面</h3>
    </div>
    <div class="col-sm-3">
      <button type="button" class="btn btn-primary" onclick={search}>検索</button>
    </div>
    <div class="col-sm-9"></div>
    <div class="col-sm-10 col-sm-offset-1 pt-3">
      <table class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th>No</th>
            <th>名前</th>
            <th>日時</th>
            <th>××情報</th>
          </tr>
        </thead>
        <tbody>
          <tr each="{ record in records }">
            <th scope="row">{record.no}</th>
            <td>{record.name}</td>
            <td>{record.date}</td>
            <td>{record.xx}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  
  <script>
    let self = this;
    self.records = [];
    
    self.search = () => {
      fetch('http://localhost:8081/search').then(response => {
        return response.json();
      }).then(json => {
        self.records = json;
        self.update();
      });
    }
  </script>
</page1>
