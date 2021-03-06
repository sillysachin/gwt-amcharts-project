package com.amcharts.impl;

import java.util.List;

import com.amcharts.api.AmChartData;
import com.amcharts.api.IsAmBalloon;
import com.amcharts.api.IsAmChart;
import com.amcharts.api.IsAmExport;
import com.amcharts.api.IsAmLegend;
import com.amcharts.api.IsCategoryAxis;
import com.amcharts.api.IsExportConfig;
import com.amcharts.api.IsLabel;
import com.amcharts.api.IsNumberPrefix;
import com.amcharts.api.IsTitle;
import com.amcharts.impl.event.AmChartEventJSO;
import com.amcharts.impl.event.AmChartListener;
import com.amcharts.jso.AmChartDataJSO;
import com.amcharts.jso.AmChartJSO;
import com.google.gwt.core.client.IJavaScriptWrapper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class AmChart implements IsAmChart, IJavaScriptWrapper<AmChartJSO> {
	protected AmChartJSO jso;

	private String id;

	private List<? extends IsTitle> titles;

	private List<IsNumberPrefix> prefixesOfSmallNumbers;

	private List<IsNumberPrefix> prefixesOfBigNumbers;

	private List<IsLabel> allLabels;

	protected AmChart() {
		init("");
	}

	protected AmChart(String id) {
		init(id);
	}

	protected void init(String id) {
		setId(id);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public AmChartJSO getJso() {
		return jso;
	}

	@Override
	public void setJso(AmChartJSO jso) {
		this.jso = jso;
	}

	// TODO: Need to provide a better alternative than JsArray<JavaScriptObject> dataProvider.
	public native void setDataProvider(JsArray<JavaScriptObject> dataProvider)
	/*-{
		this.@com.amcharts.impl.AmChart::jso.dataProvider = dataProvider;
	}-*/;

	public native void setCategoryField(String categoryField)
	/*-{
		this.@com.amcharts.impl.AmChart::jso.categoryField = categoryField;
	}-*/;

	public native void setType(String type)
	/*-{
		this.@com.amcharts.impl.AmChart::jso.type = type;
	}-*/;

	public native String getType()
	/*-{
		return this.@com.amcharts.impl.AmChart::jso.type;
	}-*/;

	public native void setTitleField(String titleField)
	/*-{
		this.@com.amcharts.impl.AmChart::jso.titleField = titleField;
	}-*/;

	public native String getTitleField()
	/*-{
		return this.@com.amcharts.impl.AmChart::jso.titleField;
	}-*/;

	public native void setValueField(String valueField)
	/*-{
		this.@com.amcharts.impl.AmChart::jso.valueField = valueField;
	}-*/;

	public native String getValueField()
	/*-{
		return this.@com.amcharts.impl.AmChart::jso.valueField;
	}-*/;

	public native String getDataDateFormat()
	/*-{
		return this.@com.amcharts.impl.AmChart::jso.dataDateFormat;
	}-*/;

	public native void setDataDateFormat(String dataDateFormat)
	/*-{
		this.@com.amcharts.impl.AmChart::jso.dataDateFormat = dataDateFormat;
	}-*/;

	public native String getPathToImages()
	/*-{
		return this.@com.amcharts.impl.AmChart::jso.pathToImages;
	}-*/;

	public native void setPathToImages(String pathToImages)
	/*-{
		this.@com.amcharts.impl.AmChart::jso.pathToImages = pathToImages;
	}-*/;

	public native IsCategoryAxis getCategoryAxisJSO()
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this)
		var categoryAxis = chart.categoryAxis;
		return categoryAxis;
	}-*/;

	@Override
	public List<IsLabel> getAllLabels() {
		return this.allLabels;
	}

	@Override
	public void setAllLabels(List<IsLabel> allLabels) {
		this.allLabels = allLabels;
		getJso().setAllLabels(allLabels);
	}

	@Override
	public native IsAmExport getAmExport() /*-{
											var amExport = @com.amcharts.impl.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(this.@com.amcharts.impl.AmChart::jso.amExport)
											return amExport;
											}-*/;

	@Override
	public native void setAmExport(IsAmExport amExport) /*-{
														var varAmExport = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(amExport)
														this.@com.amcharts.impl.AmChart::jso.amExport = varAmExport;
														}-*/;

	@Override
	public native Double getBackgroundAlpha() /*-{
												return this.@com.amcharts.impl.AmChart::jso.backgroundAlpha;
												}-*/;

	@Override
	public void setBackgroundAlpha(Double backgroundAlpha) {
		getJso().setBackgroundAlpha(backgroundAlpha);
	}

	@Override
	public native String getBackgroundColor() /*-{
												return this.@com.amcharts.impl.AmChart::jso.backgroundColor;
												}-*/;

	@Override
	public native void setBackgroundColor(String backgroundColor) /*-{
																	this.@com.amcharts.impl.AmChart::jso.backgroundColor = backgroundColor;
																	}-*/;

	@Override
	public native IsAmBalloon getBalloon() /*-{
											var balloon = @com.amcharts.impl.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(this.@com.amcharts.impl.AmChart::jso.balloon)
											return balloon;
											}-*/;

	@Override
	public native void setBalloon(IsAmBalloon balloon) /*-{
														var varBalloon = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(balloon)
														this.@com.amcharts.impl.AmChart::jso.balloon = varBalloon;
														}-*/;

	@Override
	public native Double getBorderAlpha() /*-{
											return this.@com.amcharts.impl.AmChart::jso.borderAlpha;
											}-*/;

	@Override
	public void setBorderAlpha(Double borderAlpha) {
		getJso().setBorderAlpha(borderAlpha);
	}

	@Override
	public native String getBorderColor() /*-{
											return this.@com.amcharts.impl.AmChart::jso.borderColor;
											}-*/;

	@Override
	public native void setBorderColor(String borderColor) /*-{
															this.@com.amcharts.impl.AmChart::jso.borderColor = borderColor;
															}-*/;

	@Override
	public native String getColor() /*-{
									return this.@com.amcharts.impl.AmChart::jso.color;
									}-*/;

	@Override
	public native void setColor(String color) /*-{
												this.@com.amcharts.impl.AmChart::jso.color = color;
												}-*/;

	@Override
	public native String getCreditsPosition() /*-{
												return this.@com.amcharts.impl.AmChart::jso.creditsPosition;
												}-*/;

	@Override
	public native void setCreditsPosition(String creditsPosition) /*-{
																	this.@com.amcharts.impl.AmChart::jso.creditsPosition = creditsPosition;
																	}-*/;

	@Override
	public List<? extends AmChartDataJSO> getDataProvider() {
		return getJso().getDataProvider();
	}

	@Override
	public void setDataProvider(List<? extends AmChartData> dataProvider) {
		getJso().setDataProvider(dataProvider);
	}

	@Override
	public native String getDecimalSeparator() /*-{
												return this.@com.amcharts.impl.AmChart::jso.decimalSeparator;
												}-*/;

	@Override
	public native void setDecimalSeparator(String decimalSeparator) /*-{
																	this.@com.amcharts.impl.AmChart::jso.decimalSeparator = decimalSeparator;
																	}-*/;

	@Override
	public native IsExportConfig getExportConfig() /*-{
													var exportConfig = @com.amcharts.impl.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(this.@com.amcharts.impl.AmChart::jso.exportConfig)
													return exportConfig;
													}-*/;

	@Override
	public native void setExportConfig(IsExportConfig exportConfig) /*-{
																	var varExportConfig = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(exportConfig)
																	this.@com.amcharts.impl.AmChart::jso.exportConfig = varExportConfig;
																	}-*/;

	@Override
	public native String getFontFamily() /*-{
											return this.@com.amcharts.impl.AmChart::jso.fontFamily;
											}-*/;

	@Override
	public native void setFontFamily(String fontFamily) /*-{
														this.@com.amcharts.impl.AmChart::jso.fontFamily = fontFamily;
														}-*/;

	@Override
	public native Double getFontSize() /*-{
										return this.@com.amcharts.impl.AmChart::jso.fontSize;
										}-*/;

	@Override
	public void setFontSize(Double fontSize) {
		getJso().setFontSize(fontSize);
	}

	@Override
	public native Boolean getHandDrawn() /*-{
											return this.@com.amcharts.impl.AmChart::jso.handDrawn;
											}-*/;

	@Override
	public native void setHandDrawn(Boolean handDrawn) /*-{
														this.@com.amcharts.impl.AmChart::jso.handDrawn = handDrawn;
														}-*/;

	@Override
	public native Double getHandDrawScatter() /*-{
												return this.@com.amcharts.impl.AmChart::jso.handDrawScatter;
												}-*/;

	@Override
	public void setHandDrawScatter(Double handDrawScatter) {
		getJso().setHandDrawScatter(handDrawScatter);
	}

	@Override
	public native Double getHandDrawThickness() /*-{
												return this.@com.amcharts.impl.AmChart::jso.handDrawThickness;
												}-*/;

	@Override
	public void setHandDrawThickness(Double handDrawThickness) {
		getJso().setHandDrawThickness(handDrawThickness);
	}

	@Override
	public native Double getHideBalloonTime() /*-{
												return this.@com.amcharts.impl.AmChart::jso.hideBalloonTime;
												}-*/;

	@Override
	public void setHideBalloonTime(Double hideBalloonTime) {
		getJso().setHideBalloonTime(hideBalloonTime);
	}

	@Override
	public native String getLanguage() /*-{
										return this.@com.amcharts.impl.AmChart::jso.language;
										}-*/;

	@Override
	public native void setLanguage(String language) /*-{
													this.@com.amcharts.impl.AmChart::jso.language = language;
													}-*/;

	@Override
	public native IsAmLegend getLegend() /*-{
											var legend = @com.amcharts.impl.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(this.@com.amcharts.impl.AmChart::jso.legend)
											return legend;
											}-*/;

	@Override
	public native void setLegend(IsAmLegend legend) /*-{
													var varLegend = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(legend)
													this.@com.amcharts.impl.AmChart::jso.legend = varLegend;
													}-*/;

	@Override
	public native String getLegendDiv() /*-{
										return this.@com.amcharts.impl.AmChart::jso.legendDiv;
										}-*/;

	@Override
	public native void setLegendDiv(String legendDiv) /*-{
														this.@com.amcharts.impl.AmChart::jso.legendDiv = legendDiv;
														}-*/;

	@Override
	public native Boolean getPanEventsEnabled() /*-{
												return this.@com.amcharts.impl.AmChart::jso.panEventsEnabled;
												}-*/;

	@Override
	public native void setPanEventsEnabled(Boolean panEventsEnabled) /*-{
																		this.@com.amcharts.impl.AmChart::jso.panEventsEnabled = panEventsEnabled;
																		}-*/;

	@Override
	public native Double getPercentPrecision() /*-{
												return this.@com.amcharts.impl.AmChart::jso.percentPrecision;
												}-*/;

	@Override
	public void setPercentPrecision(Double percentPrecision) {
		getJso().setPercentPrecision(percentPrecision);
	}

	@Override
	public native Double getPrecision() /*-{
										return this.@com.amcharts.impl.AmChart::jso.precision;
										}-*/;

	@Override
	public void setPrecision(Double precision) {
		getJso().setPrecision(precision);
	}

	@Override
	public List<IsNumberPrefix> getPrefixesOfBigNumbers() {
		return this.prefixesOfBigNumbers;
	}

	@Override
	public void setPrefixesOfBigNumbers(
			List<IsNumberPrefix> prefixesOfBigNumbers) {
		this.prefixesOfBigNumbers = prefixesOfBigNumbers;
		getJso().setPrefixesOfBigNumbers(prefixesOfBigNumbers);
	}

	@Override
	public List<IsNumberPrefix> getPrefixesOfSmallNumbers() {
		return this.prefixesOfSmallNumbers;
	}

	@Override
	public void setPrefixesOfSmallNumbers(
			List<IsNumberPrefix> prefixesOfSmallNumbers) {
		this.prefixesOfSmallNumbers = prefixesOfSmallNumbers;
		getJso().setPrefixesOfSmallNumbers(prefixesOfSmallNumbers);
	}

	@Override
	public native String getTheme() /*-{
									return this.@com.amcharts.impl.AmChart::jso.theme;
									}-*/;

	@Override
	public native void setTheme(String theme) /*-{
												this.@com.amcharts.impl.AmChart::jso.theme = theme;

												}-*/;

	@Override
	public native String getThousandsSeparator() /*-{
													return this.@com.amcharts.impl.AmChart::jso.thousandsSeparator;
													}-*/;

	@Override
	public native void setThousandsSeparator(String thousandsSeparator) /*-{
																		this.@com.amcharts.impl.AmChart::jso.thousandsSeparator = thousandsSeparator;
																		}-*/;

	@Override
	public List<? extends IsTitle> getTitles() {
		return this.titles;
	}

	@Override
	public void setTitles(List<? extends IsTitle> titles) {
		this.titles = titles;
		getJso().setTitles(titles);
	}

	@Override
	public native Boolean getUsePrefixes() /*-{
											this.@com.amcharts.impl.AmChart::jso.usePrefixes = usePrefixes;
											}-*/;

	@Override
	public native void setUsePrefixes(Boolean usePrefixes) /*-{
															return this.@com.amcharts.impl.AmChart::jso.usePrefixes;
															}-*/;

	@Override
	public native String getVersion() /*-{
										this.@com.amcharts.impl.AmChart::jso.version = version;
										}-*/;

	@Override
	public native void setVersion(String version) /*-{
													return this.@com.amcharts.impl.AmChart::jso.version;
													}-*/;

	public native void addLabel(String x, String y, String text, String align,
			Double size, String color, Double rotation, Double alpha,
			Boolean bold, String url)
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		chart.addLabel(x, y, text, align, size, color, rotation, alpha, bold,
				url);
	}-*/;

	public native void addLegend(IsAmLegend legend, String legendDivID)
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		var varAmLegend = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(legend)
		chart.addLegend(varAmLegend, legendDivID);
	}-*/;

	public native void addTitle(String title)
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		chart.addTitle(title);
	}-*/;

	public native void clear()
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		chart.clear();
	}-*/;

	public native void clearLabels()
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		chart.clearLabels();
	}-*/;

	public native void invalidateSize()
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		chart.invalidateSize();
	}-*/;

	public native void makeChart(String container, JavaScriptObject config,
			Double delay)
	/*-{
		this.@com.amcharts.impl.AmChart::setId(Ljava/lang/String;)(container);
		return $wnd.AmCharts.makeChart(container, configJSO, delay);
	}-*/;

	public native AmChartJSO makeChart(String container,
			JavaScriptObject configJSO)
	/*-{
		this.@com.amcharts.impl.AmChart::setId(Ljava/lang/String;)(container);
		return $wnd.AmCharts.makeChart(container, configJSO);
	}-*/;

	public native JavaScriptObject makeChart(JavaScriptObject configJSO)
	/*-{
		var container = this.@com.amcharts.impl.AmChart::getId();
		return $wnd.AmCharts.makeChart(container, configJSO);
	}-*/;

	public native void removeLegend()
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		chart.removeLegend();
	}-*/;

	// TODO: Need to provide better api than this.
	public native void removeListener(JavaScriptObject chartJSO, String type,
			JavaScriptObject handler)
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		chart.removeListener(chartJSO, type, handler);
	}-*/;

	public native void validateData()
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		chart.validateData();
	}-*/;

	public native void validateNow()
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		chart.validateNow();
	}-*/;

	public native void write(String container)
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this)
		chart.write(container);
	}-*/;

	public native void addGraph(AmGraph amGraph)
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this)
		var graph = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(amGraph)
		chart.addGraph(graph);
	}-*/;

	public native void addValueAxis(ValueAxis valueAxis)
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this)
		var valueAxis = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(valueAxis)
		chart.addValueAxis(valueAxis);
	}-*/;

	public native void addChartScrollbar(ChartScrollbar chartScrollbar)
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this)
		var chartScrollbar = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(chartScrollbar)
		chart.addChartScrollbar(chartScrollbar);
	}-*/;

	public native void addTrendLine(TrendLine trendLine)
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this)
		var trendLine = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(trendLine)
		chart.addTrendLine(trendLine);
	}-*/;

	public native void addListener(String eventName,
			AmChartListener amChartListener)
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		var amChartThis = this;
		chart
				.addListener(
						eventName,
						function(event) {
							amChartThis.@com.amcharts.impl.AmChart::handleListener(Lcom/amcharts/impl/event/AmChartListener;Lcom/amcharts/impl/event/AmChartEventJSO;)(amChartListener,event);
						});
	}-*/;

	public void handleListener(AmChartListener amChartListener,
			AmChartEventJSO event) {
		amChartListener.function(event);
	}

	public AmChartLayoutPanel asWidget() {
		AmChartLayoutPanel amChartPanel = new AmChartLayoutPanel() {
			@Override
			protected void onLoad() {
				write(getId());
			}
		};
		return amChartPanel;
	}

	public native ValueAxis getValueAxesOne()
	/*-{
		var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		var valueAxisJSO = chart.valueAxes[0];
		var valueAxis = @com.amcharts.impl.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(valueAxisJSO);
		return valueAxis;
	}-*/;

	public native void setAddClassNames(Boolean enable)
	/*-{
		this.@com.amcharts.impl.AmChart::jso.addClassNames = enable;
	}-*/;

	public native void setDefs()
	/*-{
	 	var chart = @com.amcharts.impl.util.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
	 	chart.responsive = {
		  "enabled": true
		};
		chart.defs = {
	        "filter": [
	            {
	                "id": "blur",
	                "feOffset": {
	                    "in": "SourceAlpha",
	                    "dy": 7,
	                    "result": "feOffset"
	                },
	              
	                "feGaussianBlur": {
	                    "in": "feOffset",
	                    "stdDeviation": 2,
	                    "result": "feGaussianBlur"
	                },
	                "feColorMatrix": {
	                    "result": "feGaussianBlur",
	                    "type": "matrix",
	                    "values": "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 .5 0"
	                },             
	                "feBlend": {
	                    "in": "SourceGraphic",
	                    "in2": "feGaussianBlur",
	                    "x": -10,
	                    "result": "feGaussianBlur"
	                }              
	            }
	        ] 
		}
	}-*/;
}