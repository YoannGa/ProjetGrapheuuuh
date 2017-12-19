Plotly.d3.csv('https://raw.githubusercontent.com/YoannGa/ProjetGrapheuuuh/master/toulouse.csv', function(err, rows){
			  <!-- GET https://api.jcdecaux.com/vls/v1/stations?contract={contract_name}&apiKey={90313b881f526a2b3fe7a265084db8ca6c33160c} !-->
			  
			  var classArray = unpack(rows, 'class');
			  var classes = [...new Set(classArray)];

			  function unpack(rows, key) {
			    return rows.map(function(row) { return row[key]; });
			  }

			  var data = classes.map(function(classes) {
			    var rowsFiltered = rows.filter(function(row) {
			        return (row.class === classes);
			    });
			    return {
			       type: 'scattermapbox',
			       name: "Stations Vélô",
			       lat: unpack(rowsFiltered, 'Latitude'),
			       lon: unpack(rowsFiltered, 'Longitude')
			    };
			  });
			  
			  var layout = {
				
			     title: 'Stations Velô Toulouse',
			     font: {
			         color: 'white'
			     },
			    dragmode: 'zoom', 
			    mapbox: {
				
			      center: {
			        lat: 43.5992512, 
			        lon: 1.4472688
			      }, 
			      domain: {
			        x: [0, 1], 
			        y: [0, 1]
			      }, 
			      style: 'dark', 
			      zoom: 11
			    }, 
			    margin: {
			      r: 20, 
			      t: 40, 
			      b: 20, 
			      l: 20, 
			      pad: 0
			    }, 
			    paper_bgcolor: '#191A1A', 
			    plot_bgcolor: '#191A1A', 
			    showlegend: true,
			    annotations: [{
			       x: 0,
			       y: 0,
			       xref: 'paper',
			       yref: 'paper',
			         text: 'Source: <a href="https://data.nasa.gov/Space-Science/Meteorite-Landings/gh4g-9sfh" style="color: rgb(255,255,255)">NASA</a>',
			         showarrow: false
			     }]
			  };
			  
			  Plotly.setPlotConfig({
			    mapboxAccessToken: 'pk.eyJ1IjoiZXRwaW5hcmQiLCJhIjoiY2luMHIzdHE0MGFxNXVubTRxczZ2YmUxaCJ9.hwWZful0U2CQxit4ItNsiQ'
			  });
			  
			  Plotly.plot('graphDiv', data, layout);
			});